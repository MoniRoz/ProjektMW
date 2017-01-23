export class FTValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^(((P)|(D))(\s((LPG)|(CNG)|(EE)))?)$|^((EE)(\s((P)|(D)))?)$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

