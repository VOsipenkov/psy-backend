package psy.back.chats;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import psy.back.users.UserEntity;

import java.util.UUID;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    /*
     Каждый раз при работе с чатом вызываем метод
     если чат не найдем - создадим его
     */
    public UUID start(String topic, UUID chatId, UUID userId, String login) {
        if (isNull(chatId) && chatRepository.findFirstByTopic(topic).isEmpty()) {
            return create(null, userId);
        }
        return nonNull(chatId) ?
                chatRepository.findById(chatId).get().getId() :
                chatRepository.findFirstByTopic(topic).get().getId();
    }

    private UUID create(String topic, UUID userId) {
        var chat = ChatEntity.builder()
                .userId(userId)
                .topic(topic)
                .build();
        var createdChat = chatRepository.save(chat);
        return createdChat.getId();
    }
}
