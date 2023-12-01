package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// SenderActivity.java
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSend = findViewById(R.id.btnSend);
        EditText editTextlink1 = findViewById(R.id.editTextlink);
        EditText editTextNama1 = findViewById(R.id.editTextNama);
        EditText editTextTM1 = findViewById(R.id.editTextTM);
        TextView textViewReceivedPesan = findViewById(R.id.Pesan_terima);

        Intent Balik = getIntent();
        if (Balik != null) {
            String terimaPesan = Balik.getStringExtra("pesanBalik");
            textViewReceivedPesan.setText(terimaPesan);


            btnSend.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String messageLink = editTextlink1.getText().toString();
                    String messageNama = editTextNama1.getText().toString();
                    String messageTM = editTextTM1.getText().toString();

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                    intent.putExtra("pesanLink", messageLink);
                    intent.putExtra("pesanNama", messageNama);
                    intent.putExtra("pesanTM", messageTM);
                    startActivity(intent);
                }
            });
        }
    }
}
