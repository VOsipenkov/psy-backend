package psy.back.messages;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/message")
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping
    public String receiveMessage(@Valid @RequestBody Message message) {
        log.info("Received message: {}", message.getText());
        return messageService.processMessage(message);
    }
}