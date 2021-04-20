package ro.qualitest.service;

import org.springframework.stereotype.Service;
import ro.qualitest.dto.EOperationType;
import ro.qualitest.dto.Operation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class OperationSpliterService {

    public Operation split(final String source) {
        Pattern pattern = Pattern.compile("(\\d{1,})(\\+|-|\\*|/)(\\d{1,})");
        final Matcher matcher = pattern.matcher(source);
        if (matcher.find()) {
            final String x = matcher.group(2);
            return Operation.builder()
                    .left(Integer.valueOf(matcher.group(1)))
                    .right(matcher.group(3))
                    .op(EOperationType.from(x))
                    .build();
        } else {
            return Operation.builder().left(Integer.valueOf(source)).build();
        }

    }
}
