package psy.back.history;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import psy.back.messages.Message;
import psy.back.messages.MessageEntity;
import psy.back.messages.MessageMapper;
import psy.back.messages.MessageRepository;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class HistoryService {
    @Value("${service.history.mockEnabled:false}")
    private Boolean mockEnabled;
    private static final UUID USER_ID = UUID.fromString("00000000-0000-0000-0000-000000001111");
    private static final UUID CHAT_ID = UUID.fromString("00000000-0000-0000-0000-000000000000");

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public List<Message> getHistory(UUID userId, UUID chatId) {
        log.info("Fetching mock history data userId {}, chatId {} ", userId, chatId);
        if (mockEnabled) {
            userId = USER_ID;
            chatId = CHAT_ID;
        }
        List<MessageEntity> messages = messageRepository.getHistory(userId, chatId);
        return messages.stream().map(messageMapper::toDto).collect(Collectors.toList());
    }
}
