package com.ntnn.controller;

import com.ntnn.dto.GenericSingleRestResponse;
import com.ntnn.service.TopupService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Callable;

@RestController
@RequestMapping("/transaction")
@RequiredArgsConstructor
@CrossOrigin
public class TransferMoneyController {

  private final TopupService topupService;

  @RateLimiter(name = "externalService")
  @PostMapping(value = "/topup/{accountId}", consumes = {MediaType.APPLICATION_XML_VALUE}, produces = {MediaType.APPLICATION_XML_VALUE})
  public Callable<ResponseEntity<GenericSingleRestResponse>> topup(@RequestHeader HttpHeaders httpServletRequest, @RequestBody String xmlDocument, @PathVariable("accountId") String accountId) {
    return () -> {
      return new ResponseEntity<>(topupService.topup(httpServletRequest, xmlDocument, accountId), HttpStatus.OK);
    };
  }
}
