package com.lcl.onboarding_express.service;

import com.lcl.onboarding_express.dto.CustomerRegistrationRequest;
import com.lcl.onboarding_express.model.Customer;
import com.lcl.onboarding_express.repository.CustomerRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Period;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer registerNewCustomer(CustomerRegistrationRequest request) {
        if (customerRepository.existsByEmail(request.email())) {
            throw new IllegalArgumentException("Un compte existe déjà avec cet email.");
        }

        if (Period.between(request.birthDate(), LocalDate.now()).getYears() < 18) {
            throw new IllegalArgumentException("Le client doit être majeur pour ouvrir un compte.");
        }

        Customer newCustomer = new Customer(
                request.firstName(),
                request.lastName(),
                request.email(),
                request.birthDate(),
                "COMPTE_CREE_AVEC_SUCCES"
        );

        return customerRepository.save(newCustomer);
    }
}