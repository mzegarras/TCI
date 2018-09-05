package com.tci.controller;

import com.tci.dto.Customer;
import com.tci.proxy.FakeService;
import com.tci.proxy.Response;
import com.tci.service.CustomerService;
import com.tci.service.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private FakeService fakeService;

    @Autowired
    private Operation operation;

    @Autowired
    private CustomerService customerService;

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);


    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<List<Customer>> list() {




        Response response= fakeService.query();
        logger.debug("Response:{}", response.toString());


        //System.out.print("error");
        //e.message

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");

        logger.debug("list()");


        return ResponseEntity.ok(customerService.list());

    }

    @RequestMapping(method = RequestMethod.GET,path="/{id}")
    public HttpEntity<Customer> findById(@PathVariable("id") int id) {

        Customer c1 = customerService.query(id);

        logger.debug("findById({1})",id);

        return ResponseEntity.ok(c1);

    }

    @RequestMapping(method = RequestMethod.DELETE,path="/{id}")
    public ResponseEntity<String> deleteById(@PathVariable("id") String id) {
        logger.debug("deleteById({1})",id);

        return ResponseEntity.ok("");

    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> save( @RequestBody Customer customer) {

        logger.debug("save({1})",customer.toString());

        return ResponseEntity.ok("");

    }

}
