package psy.back.messages;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import psy.back.chats.ChatEntity;
import psy.back.chats.ChatRepository;
import psy.back.chats.ChatService;
import psy.back.users.UserEntity;
import psy.back.users.UserRepository;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MessageServiceTest {
    @Autowired
    MessageService messageService;

    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    ResourceLoader resourceLoader;

    @MockitoBean
    ChatService chatService;
    @MockitoBean
    UserRepository userRepository;
    @MockitoBean
    ChatRepository chatRepository;
    @MockitoBean
    MessageRepository messageRepository;

    @DisplayName("Happy path with mocked repository")
    @Test
    public void handleMessageHappyPath() throws IOException {
        var resource = resourceLoader.getResource("classpath:message.json");
        var json = new String(resource.getInputStream().readAllBytes(), StandardCharsets.UTF_8);
        Message message = objectMapper.readValue(json, Message.class);
        when(chatService.start(anyString(), any(), any(), anyString())).thenReturn(UUID.randomUUID());
        when(userRepository.getReferenceById(any())).thenReturn(new UserEntity());
        when(chatRepository.getReferenceById(any())).thenReturn(new ChatEntity());
        when(messageRepository.save(any())).thenReturn(null);

        var result = messageService.handleMessage(message);

        Assertions.assertTrue(StringUtils.isNotEmpty(result));
        Assertions.assertEquals(message.getText(), result);
    }
}