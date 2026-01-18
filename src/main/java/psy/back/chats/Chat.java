package psy.back.chats;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "chat")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Chat {
    @Id
    private UUID id;
    @Column(nullable = false)
    private String topic;
    @Column(name = "user_id")
    private UUID userId;
    @Column(name = "created_at")
    @CreationTimestamp
    private ZonedDateTime createdAt;
}
