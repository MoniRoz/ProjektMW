export class PostcodeValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^[0-9]{2}(-|\s)[0-9]{3}$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

