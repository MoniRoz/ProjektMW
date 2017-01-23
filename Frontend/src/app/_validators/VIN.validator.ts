export class VINValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^(?=.*[A-HJ-NPR-Z])(?=.*[0-9])[0-9A-HJ-NPR-Z]{17}$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

