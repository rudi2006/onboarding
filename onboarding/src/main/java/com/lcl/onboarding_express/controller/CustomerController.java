package com.lcl.onboarding_express.controller;

import com.lcl.onboarding_express.dto.CustomerRegistrationRequest;
import com.lcl.onboarding_express.model.Customer;
import com.lcl.onboarding_express.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/onboarding")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/customers")
    public ResponseEntity<?> createAccount(@Valid @RequestBody CustomerRegistrationRequest request) {
        try {
            Customer createdCustomer = customerService.registerNewCustomer(request);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}