package com.example.kristine.message;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button btnSave, btnLoad;
    EditText etMessage;
    TextView tvDisplay;
    FileOutputStream fos;
    FileInputStream fis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSave = (Button) findViewById(R.id.btn_save);
        btnLoad = (Button) findViewById(R.id.btn_display);
        etMessage = (EditText) findViewById(R.id.et_message);
        tvDisplay = (TextView) findViewById(R.id.tv_display);
    }

    public void displayMessage(View view) {
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try {
            fis = openFileInput("output.txt");
            while((read = fis.read()) != -1 ) {
                buffer.append((char) read);
            }
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        tvDisplay.setText(buffer.toString());
    }
}
