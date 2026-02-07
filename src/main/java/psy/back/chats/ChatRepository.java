package psy.back.chats;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity, UUID> {
    Optional<ChatEntity> findFirstById(UUID id);

    List<ChatEntity> findByUserId(UUID userId);
}
