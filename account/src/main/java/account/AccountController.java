package account;

import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class AccountController {

    private final OrdersClient ordersClient;
    private final CircuitBreakerFactory<?, ?> cbFactory;

    public AccountController(OrdersClient ordersClient, CircuitBreakerFactory<?, ?> cbFactory) {
        this.ordersClient = ordersClient;
        this.cbFactory = cbFactory;
    }

    @GetMapping("/account")
    public ModelAndView index() {
        return this.cbFactory.create("orders").run(
                () -> new ModelAndView("index", Map.of("orders", this.ordersClient.fetchOrders())),
                throwable -> new ModelAndView("index", Map.of("error", "Can't fetch orders: " + throwable.getMessage())));
    }
}
