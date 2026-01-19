package psy.back.messages;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MessageMapper {

    @Mapping(target = "id", expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "text", source = "text")
    @Mapping(target = "user", ignore = true) // заполним в сервисе
    @Mapping(target = "chat", ignore = true) // заполним в сервисе
    @Mapping(target = "createdAt", ignore = true)
    MessageEntity toEntity(Message message);

    @Mapping(target = "text", source = "text")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "chatId", source = "chat.id")
    @Mapping(target = "login", ignore = true)
    @Mapping(target = "topic", ignore = true)
    Message toDto(MessageEntity record);
}
