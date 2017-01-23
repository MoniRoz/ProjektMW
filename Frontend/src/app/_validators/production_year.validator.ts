export class ProductionYearValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^([1-2][0-9])?[0-9]{2}$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

