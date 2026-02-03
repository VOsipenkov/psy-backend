package psy.back.messages;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, UUID> {

    @Query(value = "select m FROM MessageEntity m where m.user.id = :userId AND m.chat.id = :chatId ")
    List<MessageEntity> getHistory(@Param("userId") UUID userId, @Param("chatId") UUID chatId);
}
