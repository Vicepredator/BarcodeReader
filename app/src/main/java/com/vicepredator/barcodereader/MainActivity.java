package com.vicepredator.barcodereader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
        TextView resultTxt = (TextView) findViewById(R.id.txtResult);
        resultTxt.setMovementMethod(new ScrollingMovementMethod());
        BarcodeReader barRead = new BarcodeReader(MainActivity.this, findViewById(R.id.vBarReader));
        barRead.scan();
        barRead.setBarcodeReaderListener(new BarcodeReader.BarcodeReaderListener() {
            @Override
            public void onCodeScanned(String code) {
                resultTxt.setText(code);
            }
        });

        findViewById(R.id.btnCopy).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!resultTxt.getText().toString().isEmpty()){
                    ClipData clip = ClipData.newPlainText(resultTxt.getText(), resultTxt.getText());
                    clipboard.setPrimaryClip(clip);
                    resultTxt.setText(null);
                    Toast.makeText(MainActivity.this,"Code copied to clipboard",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}