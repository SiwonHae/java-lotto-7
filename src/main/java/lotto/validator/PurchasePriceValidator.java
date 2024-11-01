package lotto.validator;

import static lotto.parser.InputParser.parseInteger;
import static lotto.validator.ValidationMessage.INVALID_INPUT_FORMAT;

import lotto.exception.InvalidInputException;

public class PurchasePriceValidator {

    public void validate(String inputPurchasePrice) {
        validInputIsNotNull(inputPurchasePrice);
        validInputIsNotEmpty(inputPurchasePrice);
        validInput(inputPurchasePrice);
    }

    private void validInputIsNotNull(String inputPurchasePrice) {
        if (inputPurchasePrice == null) {
            throw new InvalidInputException(INVALID_INPUT_FORMAT.getMessage());
        }
    }

    private void validInputIsNotEmpty(String inputPurchasePrice) {
        if (inputPurchasePrice.isEmpty() || inputPurchasePrice.isBlank()) {
            throw new InvalidInputException(INVALID_INPUT_FORMAT.getMessage());
        }
    }

    private void validInput(String inputPurchasePrice) {
        try {
            parseInteger(inputPurchasePrice);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(INVALID_INPUT_FORMAT.getMessage());
        }
    }
}