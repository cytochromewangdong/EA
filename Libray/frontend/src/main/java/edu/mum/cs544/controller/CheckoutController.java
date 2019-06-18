package edu.mum.cs544.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/lib/")
@PreAuthorize("hasAuthority('lib')")
public class CheckoutController {

}
