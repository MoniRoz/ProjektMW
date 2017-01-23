export class Przeglad {
  data_wystawienia: string;
  data_waznosci: string;
  wystawiajacy: string;


  constructor(data_wystawienia: string, data_waznosci: string, wystawiajacy: string) {
    this.data_wystawienia = data_wystawienia;
    this.data_waznosci = data_waznosci;
    this.wystawiajacy = wystawiajacy;
  }
}
