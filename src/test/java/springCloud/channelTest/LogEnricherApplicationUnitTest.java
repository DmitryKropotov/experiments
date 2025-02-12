package springCloud.channelTest;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.binder.test.EnableTestBinder;
import org.springframework.cloud.stream.binder.test.InputDestination;
import org.springframework.cloud.stream.binder.test.OutputDestination;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@EnableTestBinder
@SpringBootTest
public class LogEnricherApplicationUnitTest {
    @Autowired
    private InputDestination input;

    @Autowired
    private OutputDestination output;

    @Test
    public void whenSendingLogMessage_thenMessageIsEnrichedWithPrefix() {
        input.send(MessageBuilder.withPayload("hello world").build(), "enrichLogMessage-in-0");

        Message<byte[]> message = output.receive(1000L, "enrichLogMessage-out-0");

        assertThat(message.getPayload())
                .asString()
                .isEqualTo("[Baeldung] - hello world");
    }

    @Test
    public void whenSendingLogMessage_thenItsEnrichedWithPrefix() {
        input.send(MessageBuilder.withPayload("hello world").build(), "queue.log.messages");

        Message<byte[]> message = output.receive(1000L, "queue.pretty.log.messages");

        assertThat(message.getPayload())
                .asString()
                .isEqualTo("[Baeldung] - hello world");
    }
}
