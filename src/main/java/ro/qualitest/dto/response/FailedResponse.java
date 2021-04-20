package ro.qualitest.dto.response;

import lombok.Builder;
import lombok.ToString;

@Builder
@ToString
public class FailedResponse extends AbstractResponse {

    private String errorDetail;
}
