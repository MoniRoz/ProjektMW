package com.truskawki.mw.lib;

public class Pojazd {
    private String marka;
    private String rodzaj_pojazdu;
    private String model;
    private String nr_VIN;
    private String r_paliwa;
    private String d_nr_rejestracyjny;
    private int rok_produkcji;
    private long masa;
    private long p_silnika;
    private long m_silnika;

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getRodzaj_pojazdu() {
        return rodzaj_pojazdu;
    }

    public void setRodzaj_pojazdu(String rodzaj_pojazdu) {
        this.rodzaj_pojazdu = rodzaj_pojazdu;
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

    public long getMasa() {
        return masa;
    }

    public void setMasa(long masa) {
        this.masa = masa;
    }

    public long getP_silnika() {
        return p_silnika;
    }

    public void setP_silnika(long p_silnika) {
        this.p_silnika = p_silnika;
    }

    public long getM_silnika() {
        return m_silnika;
    }

    public void setM_silnika(long m_silnika) {
        this.m_silnika = m_silnika;
    }

    public String getR_paliwa() {
        return r_paliwa;
    }

    public void setR_paliwa(String r_paliwa) {
        this.r_paliwa = r_paliwa;
    }

    public String getD_nr_rejestracyjny() {
        return d_nr_rejestracyjny;
    }

    public void setD_nr_rejestracyjny(String d_nr_rejestracyjny) {
        this.d_nr_rejestracyjny = d_nr_rejestracyjny;
    }
}
