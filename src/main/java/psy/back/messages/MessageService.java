package psy.back.messages;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class MessageService {
    private MessageRepository messageRepository;
    private MessageMapper messageMapper;

    public String handleMessage(Message message) {
        log.info("Received message {}", message.getText());
        var entity = messageMapper.toEntity(message);
        messageRepository.save(entity);
        return message.getText();
    }
}
