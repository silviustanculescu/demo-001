package ro.qualitest.dto.response;

import lombok.Builder;

import java.math.BigDecimal;

@Builder
public class SuccessfulArithmeticResponse extends AbstractResponse {

    private BigDecimal result;
}
