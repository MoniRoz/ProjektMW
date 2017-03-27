export class EPValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^[0-9]{1,3}$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

