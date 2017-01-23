export class ECCValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^[0-9]+(\.[0-9])?$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

