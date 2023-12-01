package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button BtnSendback = findViewById(R.id.Btn_back);
        TextView textViewReceivedMessageNama = findViewById(R.id.Text_receive_Nama);
        TextView textViewReceivedMessageTM = findViewById(R.id.Text_receive_TM);
        TextView textViewReceivedMessageLink = findViewById(R.id.Text_receive_Link);
        EditText Textpesan = findViewById(R.id.TextPesan);

        Intent intent = getIntent();
        if (intent != null) {
            String terimaNama = intent.getStringExtra("pesanNama");
            String terimaTM = intent.getStringExtra("pesanTM");
            String terimaLink = intent.getStringExtra("pesanLink");
            textViewReceivedMessageNama.setText(terimaNama);
            textViewReceivedMessageTM.setText(terimaTM);
            textViewReceivedMessageLink.setText(terimaLink);

            BtnSendback.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String Pesanbalik = Textpesan.getText().toString();
                    Intent Balik = new Intent( MainActivity2.this, MainActivity.class);
                    Balik.putExtra("pesanBalik", Pesanbalik);
                    startActivity(Balik);
                }
            });

        }
    }
}