export class ProductionYearValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^((19|20)\d\d)/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

