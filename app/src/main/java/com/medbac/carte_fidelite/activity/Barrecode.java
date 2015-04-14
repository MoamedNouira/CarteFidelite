package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 13/04/2015.
 */
public class Barrecode extends Activity  implements View.OnClickListener{
    private static final int WHITE = 0xFFFFFFFF;
    private static final int BLACK = 0xFF000000;
    Button scanBtn,ok;
    EditText code;
    ImageView icode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barre_code);
        scanBtn = (Button) findViewById(R.id.button);
        ok = (Button) findViewById(R.id.button2);
        icode = (ImageView) findViewById(R.id.imageView2);

        code = (EditText) findViewById(R.id.editText);
        scanBtn.setOnClickListener(this);
        ok.setOnClickListener(this);

    }


    public void onClick(View v){
        if(v.getId()==R.id.button){
            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();

        }
        if(v.getId()==R.id.button2){
            Intent data = new Intent();
            String scode = code.getText().toString();
            data.putExtra("code",scode);

            // setResult(Facvc.RESULT_OK);
            setResult(RESULT_OK, data);

            Intent i = new Intent(Barrecode.this, AffichageBarreCode.class);
            i.putExtra("scode",scode);
            // startActivity(i);
            startActivity(i);
            finish();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            String forma=  scanningResult.getFormatName();
            code.setText(scanContent);

        }else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }

    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
