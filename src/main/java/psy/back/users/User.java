package psy.back.users;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class User {
    @Schema(description = "Логин пользователя", example = "john_doe")
    private String login;
    @Schema(description = "Пароль пользователя", example = "******")
    private String password;
}
