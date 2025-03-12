package com.example.service;

// Correct JUnit 5 static imports!
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.model.Customer;
import com.example.service.CustomerService;

class CustomerServiceTest {

    private CustomerService customerService;

    @BeforeEach
    public void setUp() {
        customerService = new CustomerService();
    }

    @Test
    public void testLoginCustomer_Success() {
        Customer customer = customerService.loginCustomer("test@gmail.com", "test");
        assertNotNull(customer); // ✅ This must NOT be null
        assertEquals("test", customer.getFullName()); // ✅ Check if it's the correct user
    }

    @Test
    public void testLoginCustomer_Failure() {
        Customer customer = customerService.loginCustomer("wrong@gmail.com", "wrongpass");
        assertNull(customer); // ✅ Should be null because login failed
    }
}
