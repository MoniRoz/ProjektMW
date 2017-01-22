export class Samochod {
  rodzaj_pojazdu: string;
  marka: string;
  model: string;
  rok_produkcji: number;
  nr_VIN: string;
  masa: number;
  d_nr_rejestracyjny: string;
  p_silnika: number;
  m_silnika: number;
  r_paliwa: string;


  constructor(rodzaj_pojazdu: string, marka: string, model: string, rok_produkcji: number, nr_VIN: string, masa: number, d_nr_rejestracyjny: string, p_silnika: number, m_silnika: number, r_paliwa: string) {
    this.rodzaj_pojazdu = rodzaj_pojazdu;
    this.marka = marka;
    this.model = model;
    this.rok_produkcji = rok_produkcji;
    this.nr_VIN = nr_VIN;
    this.masa = masa;
    this.d_nr_rejestracyjny = d_nr_rejestracyjny;
    this.p_silnika = p_silnika;
    this.m_silnika = m_silnika;
    this.r_paliwa = r_paliwa;
  }
}
