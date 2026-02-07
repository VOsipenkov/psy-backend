package psy.back.messages;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import psy.back.chats.ChatRepository;
import psy.back.chats.ChatService;
import psy.back.users.UserRepository;

@Slf4j
@RequiredArgsConstructor
@Component
public class MessageService {
    private final MessageRepository messageRepository;
    private final UserRepository userRepository;
    private final ChatRepository chatRepository;
    private final ChatService chatService;
    private final MessageMapper messageMapper;

    @Transactional
    public String handleMessage(Message message) {
        log.info("Received message {}, user login {}, chatId {}",
                message.getText(), message.getLogin(), message.getChatId());

        // 1. Запускаем/продолжаем чат
        var chatId = chatService.start(message.getChatId(), message.getUserId());

        // 2. Сохраняем сообщение
        var messageEntity = messageMapper.toEntity(message);
        messageEntity.setUser(userRepository.findById(message.getUserId()).get());
        messageEntity.setChat(chatRepository.findById(chatId).get());
        messageRepository.save(messageEntity);
        return message.getText();
    }
}
