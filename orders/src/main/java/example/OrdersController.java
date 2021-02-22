package example;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
@RequestMapping("/orders")
public class OrdersController {

    @GetMapping
    Stream<Order> orders() {
        return Stream.of(
                new Order("Vortex Race 3 Keyboard", 1),
                new Order("Cherry Blue MX Keycaps", 32)
        );
    }
}
