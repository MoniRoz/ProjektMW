export class MassValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^[0-9]{1,5}$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

