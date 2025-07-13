package com.prem.oauth2.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @GetMapping("/")
  public String home(@AuthenticationPrincipal OAuth2User principal) {
    return "Welcome, " + principal.getAttribute("login");
  }

  @GetMapping("/secured")
  public String secured(@AuthenticationPrincipal OAuth2User principal) {
    return "Secure Page for: " + principal.getAttribute("login");
  }
}
