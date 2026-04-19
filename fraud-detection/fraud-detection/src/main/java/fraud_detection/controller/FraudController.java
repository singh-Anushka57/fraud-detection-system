
package fraud_detection.controller;

import fraud_detection.service.FraudDetectionService;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class FraudController {

    private final FraudDetectionService service;

    public FraudController(FraudDetectionService service) {
        this.service = service;
    }

    @GetMapping("/check")
    public Map<String, Object> checkFraud(@RequestParam double amount, @RequestParam double time) {
        int result = service.checkFraud(amount, time);

        Map<String, Object> response = new HashMap<>();
        response.put("amount", amount);
        response.put("time", time);
        response.put("fraud", result);

        if (result == 1) {
            response.put("status", "Fraud");
        } else {
            response.put("status", "Safe");
        }

        return response;
    }
}