package ro.qualitest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ro.qualitest.dto.request.ArithmeticRequest;
import ro.qualitest.dto.response.SuccessfulArithmeticResponse;
import ro.qualitest.service.ArithmeticExpressionService;
import ro.qualitest.validator.ArithmeticExpressionValidator;

import java.math.BigDecimal;

@RestController
public class ArithmeticController {

    @Autowired
    private ArithmeticExpressionService<String, BigDecimal> arithmeticService;
    @Autowired
    private ArithmeticExpressionValidator<ArithmeticRequest> arithmeticValidator;

    @PostMapping(path = "/math/calculate", consumes={MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<SuccessfulArithmeticResponse> calculate(@RequestBody final ArithmeticRequest request) {
        arithmeticValidator.validate(request);
        final BigDecimal result = arithmeticService.calculate(request.getExpression());
        return ResponseEntity.status(HttpStatus.CREATED).body(SuccessfulArithmeticResponse
                    .builder().result(result).build());
    }
}
