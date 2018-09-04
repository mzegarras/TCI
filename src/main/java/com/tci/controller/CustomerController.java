package com.tci.controller;

import com.tci.dto.Customer;
import com.tci.proxy.FakeService;
import com.tci.proxy.Response;
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

    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);


    @RequestMapping(method = RequestMethod.GET)
    public HttpEntity<List<Customer>> list() {

        Response response= fakeService.query();
        logger.debug("Response:{}", response.toString());

        Customer c1=new Customer();
        c1.setEdad(operation.sumar(4,8));
        Customer c2=new Customer();
        Customer c3=new Customer();

        List<Customer> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);

        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warn message");
        logger.error("This is an error message");

        logger.debug("list()");


        return ResponseEntity.ok(list);

    }

    @RequestMapping(method = RequestMethod.GET,path="/{id}")
    public HttpEntity<Customer> findById(@PathVariable("id") String id) {

        Customer c1=new Customer();
        c1.setId(1);
        c1.setName(id);

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
