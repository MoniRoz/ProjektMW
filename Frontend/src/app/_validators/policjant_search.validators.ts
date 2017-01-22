export class SearchPattern {
  static patternValidator(control) {
    var VIN_REGEX = /^[0-9A-HJ-NPR-Z]{17} | ^[A-Z0-9]{7}/;
    var REJESTRACJA_REGEX = /^[A-Z0-9]{7}$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

