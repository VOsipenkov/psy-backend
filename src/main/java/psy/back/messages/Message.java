package psy.back.messages;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    @Schema(description = "Логин пользователя", example = "john123")
    private String login;

    @Schema(description = "Индетификатор пользователя", example = "550e8400-e29b-41d3-a716-446655440000")
    private UUID userId;

    @Schema(description = "Индетификатор чата", example = "550e8400-e29b-41d3-a716-446655440000")
    private UUID chatId;

    @Schema(description = "Текст сообщения", example = "Приснился унитаз")
    private String text;
}
