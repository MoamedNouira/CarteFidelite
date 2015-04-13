package com.medbac.carte_fidelite.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import activity.carte_fidelite.medbac.com.cartefidelite.R;

/**
 * Created by Mohamed Nouira on 13/04/2015.
 */
public class Barrecode extends Activity  implements View.OnClickListener{

    Button scanBtn,ok;
    EditText code;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barre_code);
        scanBtn = (Button) findViewById(R.id.button);
        ok = (Button) findViewById(R.id.button2);

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

            finish();
        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {

        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
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
