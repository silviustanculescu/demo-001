package ro.qualitest.runtime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("ro.qualitest")
public class InterviewRuntimeApplication {

    public static void main(final String[] args) {

        SpringApplication.run(InterviewRuntimeApplication.class, args);
    }
}
