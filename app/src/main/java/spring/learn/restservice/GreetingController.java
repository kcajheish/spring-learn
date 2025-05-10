package spring.learn.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


// RestController is the annotation that defines the controller handling HTTP request
@RestController
public class GreetingController {

    private static final String template = "Hello %s";
    private final AtomicLong counter = new AtomicLong();

    // GetMapping direct request with /greeting path to greeting method.
    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="world") String name) {
        return new Greeting(this.counter.getAndIncrement(), String.format(template, name));
    }

}
