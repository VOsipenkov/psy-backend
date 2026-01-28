package psy.back.messages;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MessageControllerTest {

    @LocalServerPort
    private int port;

    private WebClient webClient;

    @MockitoBean
    MessageService messageService;

    @BeforeEach
    public void setUp() {
        webClient = WebClient.builder()
                .baseUrl("http://localhost:" + port)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }

    @Test
    public void handleMessageTest() {
        Message dto = new Message();
        dto.setUserId(UUID.randomUUID());
        dto.setChatId(UUID.randomUUID());
        dto.setText("Hello, test!");
        when(messageService.handleMessage(any())).thenReturn("ok");

        var response = webClient.post()
                .uri("/api/send-message")
                .bodyValue(dto)
                .retrieve()
                .toEntity(String.class)
                .block();

        Assertions.assertNotNull(response);
        Assertions.assertTrue(response.getStatusCode().is2xxSuccessful());
    }

    @Test
    public void historyTest() {

    }
}