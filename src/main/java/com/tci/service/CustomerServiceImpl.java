package com.tci.service;

import com.tci.Exception.CustomerNotFoundException;
import com.tci.dto.Customer;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public Customer query(int id) {
        
        if(id==1){
            throw new CustomerNotFoundException(id);
        }

        Customer c = new Customer();
        c.setEdad(1);
        c.setId(100);
        c.setLastName("Monzon");
        c.setName("Mossy");
        //c.setError(-200);
        return null;
    }

    @Override
    public List<Customer> list() {

        throw new RuntimeException();

        /*
        Customer c1=new Customer();
        Customer c2=new Customer();
        Customer c3=new Customer();

        List<Customer> list = new ArrayList<>();
        list.add(c1);
        list.add(c2);
        list.add(c3);


        return list;*/

    }
}
