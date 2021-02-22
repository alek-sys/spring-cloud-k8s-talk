package account;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Stream;

@Component
public class OrdersClient {

    private final RestTemplate restTemplate;

    public OrdersClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Order> fetchOrders() {
        return this.restTemplate.getForObject("http://orders/orders", List.class);
    }
}
