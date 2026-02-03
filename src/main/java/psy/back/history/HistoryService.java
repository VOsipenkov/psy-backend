package psy.back.history;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import psy.back.messages.MessageMapper;
import psy.back.messages.MessageRepository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class HistoryService {
    @Value("${service.history.mockEnabled:false}")
    private Boolean mockEnabled;

    private final MessageRepository messageRepository;
    private final MessageMapper messageMapper;

    public List<Map<String, Object>> getHistory(UUID userId, UUID chatId) {
        log.info("Fetching mock history data userId {}, chatId {} ", userId, chatId);
        if (mockEnabled) {
            return List.of(
                    Map.of(
                            "postId", 1,
                            "id", 1,
                            "name", "id labore ex et quam laborum",
                            "email", "Eliseo@gardner.biz",
                            "text", "Vlad!! enim quasi est quidem magnam voluptate ipsam eos\n" +
                                    "tempora quo necessitatibus\n" +
                                    "dolor quam autem quasi\n" +
                                    "reiciendis et nam sapiente accusantium"
                    ),
                    Map.of(
                            "postId", 1,
                            "id", 2,
                            "name", "quo vero reiciendis velit similique earum",
                            "email", "Jayne_Kuhic@sydney.com",
                            "text", "est natus enim nihil est dolore omnis voluptatem numquam\n" +
                                    "et omnis occaecati quod ullam at\n" +
                                    "voluptatem error expedita pariatur\n" +
                                    "nihil sint nostrum voluptatem reiciendis et"
                    ),
                    Map.of(
                            "postId", 1,
                            "id", 3,
                            "name", "odio adipisci rerum aut animi",
                            "email", "Nikita@garfield.biz",
                            "text", "quia molestiae reprehenderit quasi aspernatur\n" +
                                    "aut expedita occaecati aliquam eveniet laudantium\n" +
                                    "omnis quibusdam delectus saepe quia accusamus maiores nam est\n" +
                                    "cum et ducimus et vero voluptates excepturi deleniti ratione"
                    ),
                    Map.of(
                            "postId", 1,
                            "id", 4,
                            "name", "alias odio sit",
                            "email", "Lew@alysha.tv",
                            "text", "non et atque\n" +
                                    "occaecati deserunt quas accusantium unde odit nobis qui voluptatem\n" +
                                    "quia voluptas consequuntur itaque dolor\n" +
                                    "et qui rerum deleniti ut occaecati"
                    ),
                    Map.of(
                            "postId", 1,
                            "id", 5,
                            "name", "vero eaque aliquid doloribus et culpa",
                            "email", "Hayden@althea.biz",
                            "text", "harum non quasi et ratione\n" +
                                    "tempore iure ex voluptates in ratione\n" +
                                    "harum architecto fugit inventore cupiditate\n" +
                                    "voluptates magni quo et"
                    )
            );
        }
        return null;

//        List<MessageEntity> messages = messageRepository.getHistory(userId, chatId);
//        return messages.stream().map(messageMapper::toDto).collect(Collectors.toList());
    }
}
