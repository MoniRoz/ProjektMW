package com.truskawki.mw.lib;

public class VehiclePost {
    private VehicleUVM samochod;
    private OwnerUVM wlasciciel;

    public VehicleUVM getSamochod() {
        return samochod;
    }

    public void setSamochod(VehicleUVM samochod) {
        this.samochod = samochod;
    }

    public OwnerUVM getWlasciciel() {
        return wlasciciel;
    }

    public void setWlasciciel(OwnerUVM wlasciciel) {
        this.wlasciciel = wlasciciel;
    }
}
