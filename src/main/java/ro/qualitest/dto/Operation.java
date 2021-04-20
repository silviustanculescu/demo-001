package ro.qualitest.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Operation {
    private Integer left;
    private Integer right;
    private EOperationType op;
}
