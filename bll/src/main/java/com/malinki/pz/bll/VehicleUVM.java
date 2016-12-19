package com.malinki.pz.bll;

public class VehicleUVM {
	private String rodzaj_pojazdu;
	private String marka;
	private String typ;
	private String model;
	private int rok_produkcji;
	private String nr_VIN;
	private String nr_silnika;
	private String d_nr_rejestracyjny;
	private String nr_kart_pojazdu;
	private int przebieg_p_w_km;
	private String barwa_nadwozia;
	
	public VehicleUVM(){}

    private VehicleUVM(PojazdUVMBuilder builder) {
        this.rodzaj_pojazdu = builder.rodzaj_pojazdu;
        this.marka = builder.marka;
        this.typ = builder.typ;
        this.model = builder.model;
        this.rok_produkcji = builder.rok_produkcji;
        this.nr_VIN = builder.nr_VIN;
        this.nr_silnika = builder.nr_silnika;
        this.d_nr_rejestracyjny = builder.d_nr_rejestracyjny;
        this.nr_kart_pojazdu = builder.nr_kart_pojazdu;
        this.przebieg_p_w_km = builder.przebieg_p_w_km;
        this.barwa_nadwozia = builder.barwa_nadwozia;
    }
    
	public String getRodzaj_pojazdu() {
		return rodzaj_pojazdu;
	}

	public void setRodzaj_pojazdu(String rodzaj_pojazdu) {
		this.rodzaj_pojazdu = rodzaj_pojazdu;
	}

	public String getMarka() {
		return marka;
	}

	public void setMarka(String marka) {
		this.marka = marka;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
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

	public String getNr_silnika() {
		return nr_silnika;
	}

	public void setNr_silnika(String nr_silnika) {
		this.nr_silnika = nr_silnika;
	}

	public String getD_nr_rejestracyjny() {
		return d_nr_rejestracyjny;
	}

	public void setD_nr_rejestracyjny(String d_nr_rejestracyjny) {
		this.d_nr_rejestracyjny = d_nr_rejestracyjny;
	}

	public String getNr_kart_pojazdu() {
		return nr_kart_pojazdu;
	}

	public void setNr_kart_pojazdu(String nr_kart_pojazdu) {
		this.nr_kart_pojazdu = nr_kart_pojazdu;
	}

	public int getPrzebieg_p_w_km() {
		return przebieg_p_w_km;
	}

	public void setPrzebieg_p_w_km(int przebieg_p_w_km) {
		this.przebieg_p_w_km = przebieg_p_w_km;
	}

	public String getBarwa_nadwozia() {
		return barwa_nadwozia;
	}

	public void setBarwa_nadwozia(String barwa_nadwozia) {
		this.barwa_nadwozia = barwa_nadwozia;
	}
	
	public static class PojazdUVMBuilder {
		private String rodzaj_pojazdu;
		private String marka;
		private String typ;
		private String model;
		private int rok_produkcji;
		private String nr_VIN;
		private String nr_silnika;
		private String d_nr_rejestracyjny;
		private String nr_kart_pojazdu;
		private int przebieg_p_w_km;
		private String barwa_nadwozia;
		
	    public PojazdUVMBuilder rodzaj_pojazdu(String rodzaj_pojazdu) {
	        this.rodzaj_pojazdu = rodzaj_pojazdu;
	        return this;
	    }
	    
	    public PojazdUVMBuilder marka(String marka) {
	        this.marka = marka;
	        return this;
	    }
	    
	    public PojazdUVMBuilder typ(String typ) {
	        this.typ = typ;
	        return this;
	    }
	    
	    public PojazdUVMBuilder model(String model) {
	        this.model = model;
	        return this;
	    }
	    
	    public PojazdUVMBuilder rok_produkcji(int rok_produkcji) {
	        this.rok_produkcji = rok_produkcji;
	        return this;
	    }
	    
	    public PojazdUVMBuilder nr_VIN(String nr_VIN) {
	        this.nr_VIN = nr_VIN;
	        return this;
	    }
	    
	    public PojazdUVMBuilder nr_silnika(String nr_silnika) {
	        this.nr_silnika = nr_silnika;
	        return this;
	    }
	    
	    public PojazdUVMBuilder d_nr_rejestracyjny(String d_nr_rejestracyjny) {
	        this.d_nr_rejestracyjny = d_nr_rejestracyjny;
	        return this;
	    }
	    
	    public PojazdUVMBuilder nr_kart_pojazdu(String nr_kart_pojazdu) {
	        this.nr_kart_pojazdu = nr_kart_pojazdu;
	        return this;
	    }
	    
	    public PojazdUVMBuilder przebieg_p_w_km(int przebieg_p_w_km) {
	        this.przebieg_p_w_km = przebieg_p_w_km;
	        return this;
	    }
	    
	    public PojazdUVMBuilder barwa_nadwozia(String barwa_nadwozia) {
	        this.barwa_nadwozia = barwa_nadwozia;
	        return this;
	    }

	    public VehicleUVM build() {
	        return new VehicleUVM(this);
	    }
	}
}
