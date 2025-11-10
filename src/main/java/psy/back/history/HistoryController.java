package psy.back.history;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/history")
@RequiredArgsConstructor
public class HistoryController {

    private final HistoryService historyService;

    @GetMapping("/{id}")
    public List<Map<String, Object>> getHistory(@PathVariable("id") Long id) {
        log.info("Received request for history with id: {}", id);
        return historyService.getHistoryById(id);
    }
}
