package psy.back.chats;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ChatController {

    private final ChatService chatService;

    @GetMapping("/chats/{userId}")
    public ResponseEntity<List<Chat>> getAll(@PathVariable(name = "userId") UUID userId) {
        List<Chat> chats = chatService.getAll(userId);
        return ResponseEntity.ok(chats);
    }
}
