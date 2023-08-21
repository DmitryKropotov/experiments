package youtube.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import youtube.spring.service.TestService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private TestService testService;

    public TestController() {
        System.out.println("controller constructor");
    }

    @GetMapping("/test")
    public String test(String tesr) {
        System.out.println("controller");
        return testService.test();
    }

}
