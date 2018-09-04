package com.tci.service;

import com.tci.dto.Customer;

import java.util.List;

public interface CustomerService {

    Customer query(int id);

    List<Customer> list();
}
