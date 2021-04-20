package ro.qualitest.service;

import org.springframework.stereotype.Service;

public interface ArithmeticExpressionService<T, R> {

    R calculate(final T source);
}
