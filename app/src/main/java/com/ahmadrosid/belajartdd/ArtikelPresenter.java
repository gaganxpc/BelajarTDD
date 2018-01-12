package com.ahmadrosid.belajartdd;

/**
 * Created by ocittwo on 2/27/17.
 *
 * @Author Ahmad Rosid
 * @Email ocittwo@gmail.com
 * @Github https://github.com/ar-android
 * @Web http://ahmadrosid.com
 */
public class ArtikelPresenter {

    private ArtikelView artikelView;

    public ArtikelPresenter(ArtikelView artikelView) {
        this.artikelView = artikelView;
    }

    public boolean validateInputIsNotEmpty(String s){
        return s.isEmpty();
    }

    public void createArtikel(String judul, String kategory, String konten){
        if (validateInputIsNotEmpty(judul)){
            artikelView.showEmptyInputMessage("Field Judul is empty!");
        }else if (validateInputIsNotEmpty(kategory)){
            artikelView.showEmptyInputMessage("Field Kategori is empty!");
        }else if (validateInputIsNotEmpty(konten)){
            artikelView.showEmptyInputMessage("Field Konten is empty!");
        }else{
            artikelView.isSuccesValidateForm(judul, kategory, konten);
        }
    }
}
