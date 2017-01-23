export class LogbookValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^[A-Z0-9]{7}$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

