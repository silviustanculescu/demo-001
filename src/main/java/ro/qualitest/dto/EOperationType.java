package ro.qualitest.dto;

import lombok.Getter;

import java.math.BigDecimal;

public enum EOperationType {

    ADD("+") {
        BigDecimal execute(final BigDecimal one, final BigDecimal other) {
            return one.add(other);
        }
    },

    SUBSTRACT("-") {
        BigDecimal execute(final BigDecimal one, final BigDecimal other) {
            return one.subtract(other);
        }
    },

    MULTIPLY("*") {
        BigDecimal execute(final BigDecimal one, final BigDecimal other) {
            return one.multiply(other);
        }
    },

    DIVIDE("/") {
        BigDecimal execute(final BigDecimal one, final BigDecimal other) {
            return one.divide(other);
        }
    };

    @Getter
    final String op;

    abstract BigDecimal execute(final BigDecimal one, final BigDecimal other);

    EOperationType from(final String op) {
        for (EOperationType oper : EOperationType.values()) {
            if (oper.getOp().equals(op)) {
                return oper;
            }
        }
        throw new IllegalArgumentException("Operation invalid :" + op);
    }

    EOperationType(final String op) {
        this.op = op;
    }
}
