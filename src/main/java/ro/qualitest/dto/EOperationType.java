package ro.qualitest.dto;

import lombok.Getter;

import java.math.BigDecimal;

public enum EOperationType {

    ADD("+") {
        public BigDecimal execute(final BigDecimal one, final BigDecimal other) {
            return one.add(other);
        }
    },

    SUBSTRACT("-") {
        public BigDecimal execute(final BigDecimal one, final BigDecimal other) {
            return one.subtract(other);
        }
    },

    MULTIPLY("*") {
        public BigDecimal execute(final BigDecimal one, final BigDecimal other) {
            return one.multiply(other);
        }
    },

    DIVIDE("/") {
        public BigDecimal execute(final BigDecimal one, final BigDecimal other) {
            return one.divide(other);
        }
    };

    @Getter
    final String op;

    public abstract BigDecimal execute(final BigDecimal one, final BigDecimal other);

    public static EOperationType from(final String op) {
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
