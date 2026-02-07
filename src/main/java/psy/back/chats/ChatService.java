package psy.back.chats;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import psy.back.users.UserEntity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChatService {
    private final ChatRepository chatRepository;
    private final ChatMapper chatMapper;

    @Value("${service.chat.mockEnabled:false}")
    private boolean isMock;

    /*
     Каждый раз при работе с чатом вызываем метод
     если чат не найдем - создадим его
     */
    public UUID start(UUID chatId, UUID userId) {
        if (isNull(chatId)) {
            return create(userId);
        }
        return chatRepository.findById(chatId).get().getId();
    }

    public List<Chat> getAll(UUID userId) {
        if (isMock) {
            return List.of(
                    Chat.builder()
                            .userId(UUID.fromString("000e8400-e29b-41d3-a716-446655440000"))
                            .chatId(UUID.fromString("111e8400-e29b-41d3-a716-446655441111"))
                            .name("Первый сон!")
                            .build(),
                    Chat.builder()
                            .userId(UUID.fromString("000e8400-e29b-41d3-a716-446655440000"))
                            .chatId(UUID.fromString("222e8400-e29b-41d3-a716-446655442222"))
                            .name("Второй сон")
                            .build(),
                    Chat.builder()
                            .userId(UUID.fromString("000e8400-e29b-41d3-a716-446655440000"))
                            .chatId(UUID.fromString("333e8400-e29b-41d3-a716-446655443333"))
                            .name("Третий сон")
                            .build()
            );
        }
        var chatEntities = chatRepository.findByUserId(userId);
        return chatEntities.stream().map(chatMapper::toDto).collect(Collectors.toList());
    }

    private UUID create(UUID userId) {
        var chat = ChatEntity.builder()
                .userId(userId)
                .build();
        var createdChat = chatRepository.save(chat);
        return createdChat.getId();
    }
}
