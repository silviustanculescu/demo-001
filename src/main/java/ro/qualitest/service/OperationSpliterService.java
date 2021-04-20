package ro.qualitest.service;

import org.springframework.stereotype.Service;
import ro.qualitest.dto.EOperationType;
import ro.qualitest.dto.Operation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class OperationSpliterService {

    Pattern pattern = Pattern.compile("(\\d{1,})(\\+|-|\\*|/)(\\d{1,})");

    public Operation split(final String source) {
        final Matcher matcher = pattern.matcher(source);
        if (matcher.find()) {
            final String x = matcher.group(2);
            return Operation.builder()
                    .left(Integer.valueOf(matcher.group(1)))
                    .right(Integer.valueOf(matcher.group(3)))
                    .op(EOperationType.valueOf(x))
                    .build();
        } else {
            return Operation.builder().left(Integer.valueOf(source)).build();
        }

    }
}
