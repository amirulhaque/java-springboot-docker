package com.example.demo.controller;


import com.example.demo.model.EchoRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import jakarta.validation.Valid;


@RestController
@RequestMapping("/api")
public class HelloController {
private static final Logger logger = LoggerFactory.getLogger(HelloController.class);


@GetMapping("/hello")
public ResponseEntity<String> hello(@RequestParam(value = "name", required = false) String name) {
String who = (name == null || name.isBlank()) ? "world" : name.trim();
logger.info("GET /api/hello called with name={}", who);
return ResponseEntity.ok("Hello, " + who + "!");
}


@PostMapping("/echo")
public ResponseEntity<EchoRequest> echo(@Valid @RequestBody EchoRequest request) {
logger.info("POST /api/echo called with payload={}", request);
// In a real app you'd return a DTO, persist, etc. Here we just echo back.
return ResponseEntity.ok(request);
}
}
