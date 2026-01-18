package psy.back.messages;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import psy.back.chats.ChatEntity;
import psy.back.users.UserEntity;

import java.time.ZonedDateTime;
import java.util.UUID;

@Entity
@Table(name = "chat_messages")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class MessageEntity {
    @Id
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity userId;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChatEntity chatId;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "created_at", updatable = false, nullable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt;
}
