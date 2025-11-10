package psy.back.messages;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Message {
    @NotNull(message = "Text must not be null")
    private String text;
}
