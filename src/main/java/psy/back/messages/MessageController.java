package psy.back.messages;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import psy.back.history.HistoryService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
@Tag(name = "Сообщения", description = "API для отправки сообщений и получения истории в чате")
public class MessageController {

    private final MessageService messageService;
    private final HistoryService historyService;

    @PostMapping("/send-message")
    @Operation(
            summary = "Отправить сообщение",
            description = "Отправляет сообщение в чат и сохраняет в бд",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "Сообщение успешно отправлено",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = String.class)
                    )
            )
    )
    public ResponseEntity<String> handleMessage(
            @Parameter(name = "Сообщение", required = true) @RequestBody Message message) {
        messageService.handleMessage(message);
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/history/{userId}/{chatId}")
    @Operation(
            summary = "Получить историю сообщений",
            description = "по idUser и chatId получает историю сообщений пользователя с оператором",
            responses = @ApiResponse(
                    responseCode = "200",
                    description = "История сообщений загружена",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = List.class)
                    )
            )
    )
    public ResponseEntity<List<Message>> history(
            @Parameter(name = "Идентификатор пользователя", required = true) @PathVariable UUID userId,
            @Parameter(name = "Идентификатор чатика", required = true) @PathVariable UUID chatId) {
        return ResponseEntity.ok(historyService.getHistory(userId, chatId));
    }
}
