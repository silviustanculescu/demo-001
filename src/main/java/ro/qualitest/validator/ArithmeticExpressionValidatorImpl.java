package ro.qualitest.validator;

import org.springframework.stereotype.Component;
import ro.qualitest.dto.request.ArithmeticRequest;

@Component
public class ArithmeticExpressionValidatorImpl implements ArithmeticExpressionValidator<ArithmeticRequest> {

    @Override
    public void validate(final ArithmeticRequest source) {
        //TODO validate expression against regular expression
    }
}
