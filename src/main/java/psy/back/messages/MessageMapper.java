package psy.back.messages;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface MessageMapper {

    @Mapping(target="id",  expression = "java(java.util.UUID.randomUUID())")
    @Mapping(target = "text", source = "text")
    MessageEntity toEntity(Message message);

    @Mapping(target = "text", source = "text")
    Message toDto(MessageEntity record);
}
