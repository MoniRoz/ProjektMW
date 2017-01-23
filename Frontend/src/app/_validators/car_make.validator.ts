export class CarMakeValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^[A-ZĆŁŚŻŹ][a-ząćęłńóśźż]{1,20}((-|\s)[&A-ZĆŁŚŻŹ][a-ząćęłńóśźż]{0,20}){0,4}$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

