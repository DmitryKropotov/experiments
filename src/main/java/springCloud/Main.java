package springCloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import java.util.function.Function;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public Function<String, String> enrichLogMessage() {
        return value -> "[%s] - %s".formatted("Baeldung", value);
    }

    @Bean
    public Function<String, Message<String>> processLogs() {
        return log -> {
            boolean shouldBeEnriched = log.length() > 10;
            String destination = shouldBeEnriched ? "enrichLogMessage-in-0" : "queue.pretty.log.messages";

            return MessageBuilder.withPayload(log)
                    .setHeader("spring.cloud.stream.sendto.destination", destination)
                    .build();
        };
    }
}
