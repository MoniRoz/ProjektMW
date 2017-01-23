export class HousenumberValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^[0-9]{0,3}[a-z]?$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

