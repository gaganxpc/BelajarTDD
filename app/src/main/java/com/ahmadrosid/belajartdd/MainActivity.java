package com.ahmadrosid.belajartdd;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements ArtikelView {

    private EditText judul;
    private EditText kategori;
    private EditText konten;
    private Button btn_simpan;

    ArtikelPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new ArtikelPresenter(this);

        judul = (EditText) findViewById(R.id.judul);
        kategori = (EditText) findViewById(R.id.kategori);
        konten = (EditText) findViewById(R.id.konten);
        btn_simpan = (Button) findViewById(R.id.btn_simpan);

        btn_simpan.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                presenter.createArtikel(judul.getText().toString(),
                        kategori.getText().toString(),
                        konten.getText().toString());
            }
        });

    }

    @Override public void showEmptyInputMessage(String message) {
        Snackbar.make(btn_simpan, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override public void isSuccesValidateForm(String judul, String kategory, String kontent) {
        Snackbar.make(btn_simpan, "Artikel dengan judul "+ judul + " telah berhasil disimpan", Snackbar.LENGTH_SHORT).show();
    }
}
