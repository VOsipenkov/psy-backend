package psy.back.chats;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "chat")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ChatEntity {
    @Id
    private UUID id;
    
    @Column(name = "user_id")
    private UUID userId;

    @Column(name = "created_at")
    @CreationTimestamp
    private ZonedDateTime createdAt;
}
