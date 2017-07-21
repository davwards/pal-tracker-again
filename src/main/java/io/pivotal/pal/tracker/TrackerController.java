package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrackerController {

    @GetMapping("/")
    public String getHello() {
        return "hello";
    }

}
