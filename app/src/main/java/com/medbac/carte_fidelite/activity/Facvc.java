package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LayerDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

import com.medbac.carte_fidelite.Adapter.AdapterListAjouteCarteCat;
import com.medbac.carte_fidelite.Adapter.AdapterListCat;
import com.medbac.carte_fidelite.Downloader.getAllCategorie;
import com.medbac.carte_fidelite.Models.Catégories;

/**
 * Created by Mohamed Nouira on 08/04/2015.
 */
public class Facvc extends Activity  {

    EditText type_carte;
    EditText description;
    Button prendre_photo;
     ArrayList<String> cattegNom;
     ArrayList<Integer> cattegId;
    AlertDialog alertDialogS;

    Button categorie;
    Button ok;
    Uri imageUri                      = null;
    static TextView imageDetails      = null;
    public  static ImageView showImg  = null;
    Facvc CameraActivity = null;
    ArrayList<Catégories> listCatg;

    final static int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.facvc);
        CameraActivity = this;


        imageDetails = (TextView) findViewById(R.id.imageDetails);
        type_carte = (EditText) findViewById(R.id.type_carte);
        description = (EditText) findViewById(R.id.description);
        ok = (Button) findViewById(R.id.ok);
        showImg = (ImageView) findViewById(R.id.showImg);

        final Button photo = (Button) findViewById(R.id.prendre_photo);
        Button categorie =  (Button) findViewById(R.id.categorie);

        ok.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
            Intent data = new Intent();

            String stype_carte = type_carte.getText().toString();
            String sdescription = description.getText().toString();
           // Bitmap bitmapp = showImg.getDrawable().getBounds();

                data.putExtra("type_carte",stype_carte);
                data.putExtra("description",sdescription);
                data.putExtra("showImg",R.id.showImg);
              //  setResult(Facvc.RESULT_OK);
                setResult(RESULT_OK, data);

                finish();

            }

        });



        categorie.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {


                LayoutInflater li = LayoutInflater.from(Facvc.this);
                View promptsView = li.inflate(R.layout.list_cat, null);

                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(Facvc.this);

                alertDialogBuilder.setView(promptsView);
               listCatg=getAllCategorie.listCat;

                ListView listView_cat_nom = (ListView) promptsView.findViewById(R.id.listViewCat);
                Log.e("  getAllCategorie.listCat getAllCategorie.listCat", "" + listCatg.size());


                AdapterListCat adpt = new AdapterListCat(Facvc.this, getAllCategorie.listCat);
                listView_cat_nom.setAdapter(adpt);
                // set dialog message
                alertDialogBuilder.setCancelable(true);

                // create alert dialog
                alertDialogS = alertDialogBuilder.create();

                // show it
                alertDialogS.show();
                listView_cat_nom.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                    @Override
                    public void onItemClick(AdapterView<?> arg0, View arg1,
                                            int position, long arg3) {
                        // TODO Auto-generated method stub
                        alertDialogS.dismiss();
                        Toast.makeText(Facvc.this, ""+getAllCategorie.listCat.get(position).getId_catégories(), Toast.LENGTH_SHORT).show();


                    }
                });

            }
        });



        photo.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {

                /***** Define the file-name to save photo taken by Camera activity *******/
                String fileName = "ImageCarte.jpg";

                // Create parameters for Intent with filename

                ContentValues values = new ContentValues();

                values.put(MediaStore.Images.Media.TITLE, fileName);

                values.put(MediaStore.Images.Media.DESCRIPTION,"Capture d'image par la caméra");

                /****** imageUri is the current activity attribute, define and save it for later usage  *****/
                imageUri = getContentResolver().insert(
                        MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

                /******   EXTERNAL_CONTENT_URI : style URI for the "primary" external storage volume. ******/


                /******  Standard Intent action that can be sent to have the camera application capture an image and return it. ******/

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

                intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);

                intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY, 1);

                startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);

            }

        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {

            if (resultCode == RESULT_OK) {

                String imageId = convertImageUriToFile(imageUri,CameraActivity);

                new LoadImagesFromSDCard().execute(""+imageId);


            } else if (resultCode == RESULT_CANCELED) {

                Toast.makeText(this, "Photo n'a pas été prise", Toast.LENGTH_SHORT).show();
            } else {

                Toast.makeText(this, "Photo n'a pas été prise", Toast.LENGTH_SHORT).show();
            }
        }
    }


    public static String convertImageUriToFile (Uri imageUri, Activity activity)  {
        Cursor cursor = null;
        int imageID = 0;

        try {
            /*********** Which columns values want to get *******/
            String [] proj={
                    MediaStore.Images.Media.DATA,
                    MediaStore.Images.Media._ID,
                    MediaStore.Images.Thumbnails._ID,
                    MediaStore.Images.ImageColumns.ORIENTATION
            };

            cursor = activity.managedQuery(

                    imageUri,   // Get data for specific image URI
                    proj,       // Which columns to return
                    null,       // WHERE clause; which rows to return (all rows)
                    null,       // WHERE clause selection arguments (none)
                    null        // Order-by clause (ascending by name)

            );

            int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media._ID);
            int columnIndexThumb = cursor.getColumnIndexOrThrow(MediaStore.Images.Thumbnails._ID);
            int file_ColumnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            //int orientation_ColumnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.ImageColumns.ORIENTATION);

            int size = cursor.getCount();

            /*******  If size is 0, there are no images on the SD Card. *****/

            if (size == 0) {
                imageDetails.setText("pas d'image");
            }
            else
            {

                int thumbID = 0;
                if (cursor.moveToFirst()) {

                    /**************** Captured image details ************/

                    /*****  Used to show image on view in LoadImagesFromSDCard class ******/
                    imageID = cursor.getInt(columnIndex);

                    thumbID   = cursor.getInt(columnIndexThumb);

                    String Path = cursor.getString(file_ColumnIndex);

                    //String orientation =  cursor.getString(orientation_ColumnIndex);

                    String CapturedImageDetails = " CapturedImageDetails : \n\n"
                            +" ImageID :"+imageID+"\n"
                            +" ThumbID :"+thumbID+"\n"
                            +" Path :"+Path+"\n";

                    // Show Captured Image detail on view
                    imageDetails.setText(CapturedImageDetails);

                }
            }
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return ""+imageID;
    }


    /**
     * Async task for loading the images from the SD card.
     *
     * @author Android Example
     *
     */
    // Class with extends AsyncTask class
    public class LoadImagesFromSDCard  extends AsyncTask<String, Void, Void> {

        private ProgressDialog Dialog = new ProgressDialog(Facvc.this);

        Bitmap mBitmap;

        protected void onPreExecute() {
            /****** NOTE: You can call UI Element here. *****/

            //UI Element
            Dialog.setMessage("Loading image from Sdcard..");
            Dialog.show();
        }

        // Call after onPreExecute method
        protected Void doInBackground(String... urls) {

            Bitmap bitmap = null;
            Bitmap newBitmap = null;
            Uri uri = null;


            try {

                /**  Uri.withAppendedPath Method Description
                 * Parameters
                 *    baseUri  Uri to append path segment to
                 *    pathSegment  encoded path segment to append
                 * Returns
                 *    a new Uri based on baseUri with the given segment appended to the path
                 */

                uri = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "" + urls[0]);

                /**************  Decode an input stream into a bitmap. *********/
                bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));

                if (bitmap != null) {

                    /********* Creates a new bitmap, scaled from an existing bitmap. ***********/

                    newBitmap = Bitmap.createScaledBitmap(bitmap, 170, 170, true);

                    bitmap.recycle();

                    if (newBitmap != null) {

                        mBitmap = newBitmap;
                    }
                }
            } catch (IOException e) {
                //Error fetching image, try to recover

                /********* Cancel execution of this task. **********/
                cancel(true);
            }

            return null;
        }

        protected void onPostExecute(Void unused) {

            // NOTE: You can call UI Element here.

            // Close progress dialog
            Dialog.dismiss();

            if(mBitmap != null)
                showImg.setImageBitmap(mBitmap);

        }

    }

}

