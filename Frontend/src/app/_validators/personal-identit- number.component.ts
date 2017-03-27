export class P_I_NumberValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^\d{11}$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

