package psy.back.messages;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MessageRepositoryTest {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    ResourceLoader resourceLoader;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MessageMapper messageMapper;

    @Test
    public void saveTest() throws IOException {
        var resource = resourceLoader.getResource("classpath:message.json");
        var json = new String(
                resource.getInputStream().readAllBytes(),
                StandardCharsets.UTF_8);
        Message message = objectMapper.readValue(json, Message.class);
        var entity = messageMapper.toEntity(message);

        var savedEntity = messageRepository.save(entity);

        Assertions.assertNotNull(savedEntity);
        Assertions.assertNotNull(savedEntity.getId());
    }
}