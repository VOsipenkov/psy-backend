package psy.back.users;

import org.apache.tomcat.util.codec.binary.Base64;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.nio.charset.StandardCharsets;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, imports = {Base64.class, StandardCharsets.class})
public interface UserMapper {

    @Mapping(target = "login", source = "login")
    @Mapping(target = "password", expression = "java(encodeToBase64(user.getPassword()))")
    UserEntity toEntity(User user);

    default String toBase64(String text){
        return Base64.encodeBase64String(text.getBytes(StandardCharsets.UTF_8));
    }
}
