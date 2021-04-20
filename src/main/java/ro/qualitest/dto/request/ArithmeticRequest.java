package ro.qualitest.dto.request;

import lombok.Getter;

@Getter
public class ArithmeticRequest extends AbstractRequest {

    private String expression;
}
