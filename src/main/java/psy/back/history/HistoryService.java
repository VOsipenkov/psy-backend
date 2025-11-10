package psy.back.history;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class HistoryService {

    public List<Map<String, Object>> getHistoryById(Long id) {
        log.info("Fetching mock history data for id: {}", id);

        return List.of(
                Map.of(
                        "postId", 1,
                        "id", 1,
                        "name", "id labore ex et quam laborum",
                        "email", "Eliseo@gardner.biz",
                        "body", "laudantium enim quasi est quidem magnam voluptate ipsam eos\n" +
                                "tempora quo necessitatibus\n" +
                                "dolor quam autem quasi\n" +
                                "reiciendis et nam sapiente accusantium"
                ),
                Map.of(
                        "postId", 1,
                        "id", 2,
                        "name", "quo vero reiciendis velit similique earum",
                        "email", "Jayne_Kuhic@sydney.com",
                        "body", "est natus enim nihil est dolore omnis voluptatem numquam\n" +
                                "et omnis occaecati quod ullam at\n" +
                                "voluptatem error expedita pariatur\n" +
                                "nihil sint nostrum voluptatem reiciendis et"
                ),
                Map.of(
                        "postId", 1,
                        "id", 3,
                        "name", "odio adipisci rerum aut animi",
                        "email", "Nikita@garfield.biz",
                        "body", "quia molestiae reprehenderit quasi aspernatur\n" +
                                "aut expedita occaecati aliquam eveniet laudantium\n" +
                                "omnis quibusdam delectus saepe quia accusamus maiores nam est\n" +
                                "cum et ducimus et vero voluptates excepturi deleniti ratione"
                ),
                Map.of(
                        "postId", 1,
                        "id", 4,
                        "name", "alias odio sit",
                        "email", "Lew@alysha.tv",
                        "body", "non et atque\n" +
                                "occaecati deserunt quas accusantium unde odit nobis qui voluptatem\n" +
                                "quia voluptas consequuntur itaque dolor\n" +
                                "et qui rerum deleniti ut occaecati"
                ),
                Map.of(
                        "postId", 1,
                        "id", 5,
                        "name", "vero eaque aliquid doloribus et culpa",
                        "email", "Hayden@althea.biz",
                        "body", "harum non quasi et ratione\n" +
                                "tempore iure ex voluptates in ratione\n" +
                                "harum architecto fugit inventore cupiditate\n" +
                                "voluptates magni quo et"
                )
        );
    }
}
