export class StreetValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^[A-ZĆŁŚŻŹ][a-zA-ZąćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}((-|\s)[A-ZĆŁŚŻŹ][a-zA-ZąćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}){0,5}$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

