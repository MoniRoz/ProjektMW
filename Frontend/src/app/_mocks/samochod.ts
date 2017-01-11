export class Samochod {
  rodzaj_pojazdu: string;
  marka: string;
  typ: string;
  model: string;
  rok_produkcji: string;
  nr_VIN: string;
  nr_silnika: string;
  d_nr_rejestracyjny: string;
  nr_kart_pojazdu: string;
  przebieg_p_w_km: string;
  barwa_nadwozia: string;

  constructor(rodzaj_pojazdu: string, marka: string, typ: string, model: string, rok_produkcji: string, nr_VIN: string, nr_silnika: string, d_nr_rejestracyjny: string, nr_kart_pojazdu: string, przebieg_p_w_km: string, barwa_nadwozia: string) {
    this.rodzaj_pojazdu = rodzaj_pojazdu;
    this.marka = marka;
    this.typ = typ;
    this.model = model;
    this.rok_produkcji = rok_produkcji;
    this.nr_VIN = nr_VIN;
    this.nr_silnika = nr_silnika;
    this.d_nr_rejestracyjny = d_nr_rejestracyjny;
    this.nr_kart_pojazdu = nr_kart_pojazdu;
    this.przebieg_p_w_km = przebieg_p_w_km;
    this.barwa_nadwozia = barwa_nadwozia;
  }
}
