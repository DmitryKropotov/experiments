package youtube.spring.service;

import org.springframework.stereotype.Service;

@Service
public class TestService {

    public TestService() {
        System.out.println("service constructor");
    }

    public String test() {
        return "success";
    }
}
