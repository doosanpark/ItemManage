package com.item;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class TestDataController {
  private final TestService testService;

  @GetMapping("/hello")
  public String hello() {
    return "Hello World";
  }

  @PostMapping("/test")
  public List<portfolio> test() {

    return testService.getAllDataList();
  }
  
  @RequestMapping(value = "testData", method = RequestMethod.POST)
  public List<portfolio> testData() {
	  
	  return testService.getAllDataList();
  }
}