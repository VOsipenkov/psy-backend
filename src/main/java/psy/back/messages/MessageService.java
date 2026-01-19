package psy.back.messages;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import psy.back.chats.ChatRepository;
import psy.back.chats.ChatService;
import psy.back.users.UserRepository;

@Slf4j
@RequiredArgsConstructor
@Component
public class MessageService {
    private MessageRepository messageRepository;
    private UserRepository userRepository;
    private ChatRepository chatRepository;
    private ChatService chatService;
    private MessageMapper messageMapper;

    public String handleMessage(Message message) {
        log.info("Received message {}, user login {}, chatId {}",
                message.getText(), message.getLogin(), message.getChatId());

        // 1. Запускаем/продолжаем чат
        var chatId = chatService.start(
                message.getTopic(), message.getChatId(), message.getUserId(), message.getLogin());

        // 2. Сохраняем сообщение
        var entity = messageMapper.toEntity(message);
        entity.setUser(userRepository.getReferenceById(message.getUserId()));
        entity.setChat(chatRepository.getReferenceById(chatId));
        messageRepository.save(entity);
        return message.getText();
    }
}
