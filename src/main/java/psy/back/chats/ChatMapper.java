package psy.back.chats;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ChatMapper {
    ChatEntity toEntity(Chat chat);

    @Mapping(source = "id", target = "chatId")
    @Mapping(source = "userId", target = "userId")
    Chat toDto(ChatEntity entity);
}
