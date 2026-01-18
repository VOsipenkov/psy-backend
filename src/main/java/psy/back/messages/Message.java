package psy.back.messages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message {
    private String login;
    private UUID userId;
    private String topic;
    private UUID chatId;
    private String text;
}
