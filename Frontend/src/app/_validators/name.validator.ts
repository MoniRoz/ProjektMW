export class NameValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^[A-ZŁŻ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

