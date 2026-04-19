package fraud_detection.service;

import fraud_detection.entity.Transaction;
import fraud_detection.repository.TransactionRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FraudDetectionService {

    private final String API_URL = "http://127.0.0.1:8000/predict";

    private final TransactionRepository repository;

    public FraudDetectionService(TransactionRepository repository) {
        this.repository = repository;
    }

    public int checkFraud(double amount, double time) {
        RestTemplate restTemplate = new RestTemplate();

        String url = API_URL + "?amount=" + amount + "&time=" + time;

        String response = restTemplate.postForObject(url, null, String.class);

        int result = (response != null && response.contains("1")) ? 1 : 0;

        // 🔥 SAVE TO DATABASE
        Transaction txn = new Transaction(amount, time, result);
        repository.save(txn);

        return result;
    }
}