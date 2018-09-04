package com.tci.Exception;

public class CustomerNotFoundException extends RuntimeException {


    private final Long id;

    public CustomerNotFoundException(final long id) {
        super("Customer could not be found with id: " + id);
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
