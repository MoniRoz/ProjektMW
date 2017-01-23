export class IServicingValidator {
  static patternValidator(control) {
    var VIN_REGEX = /^[A-ZŁŻ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}[A-ZĆŁŚŻŹ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20}((-|\s)[A-ZĆŁŚŻŹ][a-ząćęłńóśźżĄĘŁŃÓŚŹŻ]{1,20})?$/;
    if (!VIN_REGEX.test(control.value)) {
      return {invalidPATTERN: true};
    }
  }
}

