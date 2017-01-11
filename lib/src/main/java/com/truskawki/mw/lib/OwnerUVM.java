package com.truskawki.mw.lib;

public class OwnerUVM {
    private String imie;
    private String nazwisko;
    private String ulica;
    private int nr_domu;
    private String kod_pocztowy;
    private String miejscowosc;
    private long pesel;

    public OwnerUVM(){}

    private OwnerUVM(OwnerUVM.OwnerUVMBuilder builder) {
        this.imie = builder.imie;
        this.nazwisko = builder.nazwisko;
        this.ulica = builder.ulica;
        this.nr_domu = builder.nr_domu;
        this.kod_pocztowy = builder.kod_pocztowy;
        this.miejscowosc = builder.miejscowosc;
        this.pesel = builder.pesel;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    public int getNr_domu() {
        return nr_domu;
    }

    public void setNr_domu(int nr_domu) {
        this.nr_domu = nr_domu;
    }

    public String getKod_pocztowy() {
        return kod_pocztowy;
    }

    public void setKod_pocztowy(String kod_pocztowy) {
        this.kod_pocztowy = kod_pocztowy;
    }

    public String getMiejscowosc() {
        return miejscowosc;
    }

    public void setMiejscowosc(String miejscowosc) {
        this.miejscowosc = miejscowosc;
    }

    public long getPesel() {
        return pesel;
    }

    public void setPesel(long pesel) {
        this.pesel = pesel;
    }


    public static class OwnerUVMBuilder {
        private String imie;
        private String nazwisko;
        private String ulica;
        private int nr_domu;
        private String kod_pocztowy;
        private String miejscowosc;
        private long pesel;

        public OwnerUVM.OwnerUVMBuilder imie(String imie) {
            this.imie = imie;
            return this;
        }

        public OwnerUVM.OwnerUVMBuilder nazwisko(String nazwisko) {
            this.nazwisko = nazwisko;
            return this;
        }

        public OwnerUVM.OwnerUVMBuilder ulica(String ulica) {
            this.ulica = ulica;
            return this;
        }

        public OwnerUVM.OwnerUVMBuilder nr_domu(int nr_domu) {
            this.nr_domu = nr_domu;
            return this;
        }

        public OwnerUVM.OwnerUVMBuilder kod_pocztowy(String kod_pocztowy) {
            this.kod_pocztowy = kod_pocztowy;
            return this;
        }

        public OwnerUVM.OwnerUVMBuilder miejscowosc(String miejscowosc) {
            this.miejscowosc = miejscowosc;
            return this;
        }

        public OwnerUVM.OwnerUVMBuilder pesel(long pesel) {
            this.pesel = pesel;
            return this;
        }

        public OwnerUVM build() {
            return new OwnerUVM(this);
        }
    }
}
