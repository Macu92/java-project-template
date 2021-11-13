package com.macu.template;

import com.macu.template.config.documentation.DocumentationTag;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/test")
@Validated
@Api(tags = {DocumentationTag.TEST})
public class TestController {

  @PostMapping
  @ApiOperation(value = "Test endpoint name")
  public HttpStatus testEndpoint(@Valid @RequestBody TestObject obj) {
    return HttpStatus.OK;
  }
}
