export class CarTypeValidator {
  static patternValidator(control) {
    var VIN_REGEX = /	^[a-ząćęłńóśźż]{3,10}(a-ząćęłńóśźż]{3,15})?$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

