package com.truskawki.mw.lib;

public class Pojazd {
    private String marka;
    private String rodzaj;
    private String model;
    private int rok_produkcji;
    private String nr_VIN;
    private int masa;
    private int pojemnosc_silnika;
    private int moc_silnika;
    private int zasilanie;
    private String nr_rejestracyjny;

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getRodzaj() {
        return rodzaj;
    }

    public void setRodzaj(String rodzaj) {
        this.rodzaj = rodzaj;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getRok_produkcji() {
        return rok_produkcji;
    }

    public void setRok_produkcji(int rok_produkcji) {
        this.rok_produkcji = rok_produkcji;
    }

    public String getNr_VIN() {
        return nr_VIN;
    }

    public void setNr_VIN(String nr_VIN) {
        this.nr_VIN = nr_VIN;
    }

    public int getMasa() {
        return masa;
    }

    public void setMasa(int masa) {
        this.masa = masa;
    }

    public int getPojemnosc_silnika() {
        return pojemnosc_silnika;
    }

    public void setPojemnosc_silnika(int pojemnosc_silnika) {
        this.pojemnosc_silnika = pojemnosc_silnika;
    }

    public int getMoc_silnika() {
        return moc_silnika;
    }

    public void setMoc_silnika(int moc_silnika) {
        this.moc_silnika = moc_silnika;
    }

    public int getZasilanie() {
        return zasilanie;
    }

    public void setZasilanie(int zasilanie) {
        this.zasilanie = zasilanie;
    }

    public String getNr_rejestracyjny() {
        return nr_rejestracyjny;
    }

    public void setNr_rejestracyjny(String nr_rejestracyjny) {
        this.nr_rejestracyjny = nr_rejestracyjny;
    }
}
