package com.macu.template;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
@Validated
public class TestController {

  @PostMapping
  public HttpStatus readProcessViewById(@Valid @RequestBody TestObject obj) {
    return HttpStatus.OK;
  }
}
