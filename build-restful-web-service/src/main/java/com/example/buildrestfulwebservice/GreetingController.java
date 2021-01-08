package com.example.buildrestfulwebservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * In Spring's approach to building RESTful web services, HTTP requests are handled by controllers
 */
@RestController
public final class GreetingController {
  private static final String template = "Hello, %s!";
  private final AtomicLong counter = new AtomicLong();

  @GetMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name){
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }
}
