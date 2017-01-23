export class EDateValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^((19|20)\d\d)(-|\/|\.)(0[1-9]|1[012])(-|\/|\.)(0[1-9]|[12][0-9]|3[01])$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

