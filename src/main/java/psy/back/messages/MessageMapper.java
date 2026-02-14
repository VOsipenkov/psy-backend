package psy.back.messages;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface MessageMapper {

    @Mapping(target = "text", source = "text")
    @Mapping(target = "user", ignore = true) // заполним в сервисе
    @Mapping(target = "chat", ignore = true) // заполним в сервисе
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "isUser", constant = "true")
    MessageEntity toEntity(Message message);

    @Mapping(target = "text", source = "text")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "chatId", source = "chat.id")
    @Mapping(target = "login", ignore = true)
    @Mapping(target = "isUser", source = "isUser")
    Message toDto(MessageEntity record);
}
