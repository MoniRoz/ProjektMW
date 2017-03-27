package com.truskawki.mw.lib;

public class PojazdPost {
    private Pojazd samochod;
    private Wlasciciel wlasciciel;

    public void setSamochod(Pojazd samochod) {
        this.samochod = samochod;
    }

    public Pojazd getSamochod() {
        return samochod;
    }

    public Wlasciciel getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(Wlasciciel wlasciciel) {
        this.wlasciciel = wlasciciel;
    }
}
