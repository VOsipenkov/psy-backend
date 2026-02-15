package psy.back.users;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@Tag(name = "Пользователи", description = "API для регистрации новых пользователей")
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    @Operation(summary = "Регистрация пользователя",
            description = "Регистрирует нового пользователя в системе")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Новый пользователь зарегистрирован",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = String.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Ошибка. Пользователь уже существует в системе",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = String.class)
                    )
            )
    })
    public ResponseEntity<String> register(
            @Parameter(name = "Информация по пользователю", required = true) @RequestBody User user) {
        userService.register(user);
        return ResponseEntity.ok("000e8400-e29b-41d3-a716-446655440000");
    }

    @PostMapping("/login")
    @Operation(description = "Логин пользователя",
            summary = "Аутентификация и получение JWT токена")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Пароль подошел и отправлен JWT токен",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = String.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "403",
                    description = "Пароль не подошел",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = String.class)
                    )
            )
    })
    public ResponseEntity<String> login(
            @Parameter(name = "Информация по пользователю", required = true) @RequestBody User user) {
        var isSuccess = userService.login(user);
        if (isSuccess) {
            return ResponseEntity.ok("000e8400-e29b-41d3-a716-446655440000");
        }
        return new ResponseEntity<>(HttpStatus.FORBIDDEN);
    }
}
