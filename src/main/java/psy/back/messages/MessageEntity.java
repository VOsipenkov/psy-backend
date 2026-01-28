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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_seq")
    @SequenceGenerator(
            name = "message_seq",
            sequenceName = "message_seq",
            allocationSize = 1
    )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserEntity user;

    @ManyToOne(fetch = FetchType.LAZY)
    private ChatEntity chat;

    @Column(name = "text", nullable = false)
    private String text;

    @Column(name = "created_at", updatable = false, nullable = false)
    @CreationTimestamp
    private ZonedDateTime createdAt;
}
