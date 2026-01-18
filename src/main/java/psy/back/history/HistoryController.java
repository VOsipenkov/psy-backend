package psy.back.history;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;

    @GetMapping("/history/{id}")
    public List<Map<String, Object>> getHistory(@PathVariable String id) {
        log.info("Received request for history for id {}", id);
        return historyService.getHistory();
    }
}
