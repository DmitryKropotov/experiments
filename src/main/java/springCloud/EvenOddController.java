package springCloud;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EvenOddController {
    @GetMapping("/validate/prime-number")
    public String isNumberPrime(@RequestParam("number") int number) {
        return number % 2 == 0 ? "Even" : "Odd";
    }
}
