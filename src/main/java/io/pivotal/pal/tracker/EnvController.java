package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class EnvController {

    private final String port;
    private final String instance;
    private final String memory;
    private final String address;

    public EnvController(@Value("${PORT:NOT SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT SET}") String memory,
                         @Value("${CF_INSTANCE_INDEX:NOT SET}") String instance,
                         @Value("${CF_INSTANCE_ADDR:NOT SET}") String address) {
        this.port = port;
        this.instance = instance;
        this.memory = memory;
        this.address = address;
    }

    @GetMapping("/env")
    public Map<String, String> getEnv() {
        Map<String, String> map = new HashMap<>();
        map.put("PORT", port);
        map.put("CF_INSTANCE_INDEX", instance);
        map.put("MEMORY_LIMIT", memory);
        map.put("CF_INSTANCE_ADDR", address);
        return map;
    }
}
