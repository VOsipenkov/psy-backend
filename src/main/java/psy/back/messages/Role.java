package psy.back.messages;

import lombok.Getter;

import java.util.Arrays;

@Getter
public enum Role {
    USER("user"), ASSISTANT("assistant"), SYSTEM("system");

    Role(String name) {
        this.name = name;
    }

    private final String name;

    public static Role getRole(String roleName) {
        return Arrays.stream(Role.values()).filter(role -> role.name.equals(roleName)).findFirst().orElseThrow();
    }
}
