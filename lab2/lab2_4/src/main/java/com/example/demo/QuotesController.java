package com.example.demo;


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuotesController {

	private static final String template = "All shows:, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/api/quotes")
	public Quotes quotes(@RequestParam(value = "show") String quote) {
		return new Quotes(quote);
	}

	@GetMapping("/api/shows")
	public Quotes quote(String name) {
		return new Quotes(counter.incrementAndGet(), String.format(template, name));
	}
}
