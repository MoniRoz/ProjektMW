export class PoliceSearchValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^(?=.*[A-HJ-NPR-Z])(?=.*[0-9])[0-9A-HJ-NPR-Z]{17}$|^[A-Z0-9]{7}$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

