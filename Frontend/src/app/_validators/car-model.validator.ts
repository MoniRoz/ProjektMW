export class CMValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^[A-ZĆŁŚŻŹ0-9][A-Za-ząćęłńóśźż0-9]{1,20}((-|\s)[A-ZĆŁŚŻŹ0-9][A-Za-ząćęłńóśźż0-9]{0,20}){0,4}$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

