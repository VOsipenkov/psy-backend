package psy.back.messages;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/send-message")
    public ResponseEntity<String> handleMessage(@RequestBody Message message) {
        messageService.handleMessage(message);
        return ResponseEntity.ok("ok");
    }
}
