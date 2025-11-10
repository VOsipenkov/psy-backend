package psy.back.messages;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class MessageService {

    public String processMessage(Message message) {
        log.info("Processing message: {}", message.getText());
        return "Message received: " + message.getText();
    }
}
