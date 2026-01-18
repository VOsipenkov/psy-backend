package psy.back.chats;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import psy.back.users.UserEntity;

import java.util.UUID;

import static java.util.Objects.isNull;

@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;

    public UUID start(UUID chatId, UserEntity user) {
        if (isNull(chatId) || chatRepository.findById(chatId).isEmpty()) {
            return create(null, user);
        }
        return chatId;
    }

    private UUID create(String topic, UserEntity user) {
        var chat = ChatEntity.builder()
                .userId(user.getId())
                .topic(topic)
                .build();
        var createdChat = chatRepository.save(chat);
        return createdChat.getId();
    }
}
