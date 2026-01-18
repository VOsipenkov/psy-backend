package psy.back.messages;

import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import psy.back.history.HistoryService;
import psy.back.users.User;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class MessageController {

    private final MessageService messageService;
    private final HistoryService historyService;

    @PostMapping("/send-message")
    public ResponseEntity<String> handleMessage(@RequestBody Message message) {
        messageService.handleMessage(message);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/history/{userId}/{chatId}")
    public ResponseEntity<List<Map<String, Object>>> history(
            @PathVariable UUID userId,
            @PathVariable UUID chatId) {
        return ResponseEntity.ok(historyService.getHistory(userId, chatId));
    }
}
