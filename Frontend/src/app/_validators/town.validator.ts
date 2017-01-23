export class TownValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^[A-ZŁÓŚŹŻ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

