export class Wlasciciel {
  imie: string;
  nazwisko: string;
  ulica: string;
  nr_domu: string;
  kod_pocztowy: string;
  miejscowosc: string;
  pesel: number;


  constructor(imie: string, nazwisko: string, ulica: string, nr_domu: string, kod_pocztowy: string, miejscowosc: string, pesel: number) {
    this.imie = imie;
    this.nazwisko = nazwisko;
    this.ulica = ulica;
    this.nr_domu = nr_domu;
    this.kod_pocztowy = kod_pocztowy;
    this.miejscowosc = miejscowosc;
    this.pesel = pesel;
  }
}
