package com.ntnn.controller;

import com.ntnn.dto.DiffieHellmanResponse;
import com.ntnn.service.DiffieHellmanService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/diffieHellman")
@RequiredArgsConstructor
public class DiffieHellmanController {

  @Autowired
  private DiffieHellmanService diffieHellmanService;

  @RateLimiter(name = "externalService")
  @PostMapping(value = "/exchangeKey", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<DiffieHellmanResponse> diffieHellman() {
    return new ResponseEntity<>(diffieHellmanService.diffieHellman(), HttpStatus.OK);
  }

  @RateLimiter(name = "externalService")
  @PostMapping(value = "/signature/{apId}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> signature(@PathVariable("apId") String apId) {
    return new ResponseEntity<>(diffieHellmanService.signature(apId), HttpStatus.OK);
  }

}
