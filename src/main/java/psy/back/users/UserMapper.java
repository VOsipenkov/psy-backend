package psy.back.users;

import org.apache.tomcat.util.codec.binary.Base64;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;

import java.nio.charset.StandardCharsets;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE,
        imports = {StandardCharsets.class},
        componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "login", source = "login")
    @Mapping(target = "password", source = "password", qualifiedByName = "toBase64")
    UserEntity toEntity(User user);

    @Named("toBase64")
    default String toBase64(String text) {
        return java.util.Base64.getEncoder().encodeToString(text.getBytes(StandardCharsets.UTF_8));
    }
}
