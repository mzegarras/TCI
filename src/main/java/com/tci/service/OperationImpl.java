package com.tci.service;

import com.tci.controller.CustomerController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class OperationImpl implements  Operation {

    private static final Logger logger = LoggerFactory.getLogger(OperationImpl.class);

    @Override
    public int sumar(int n1, int n2) {
        logger.warn("{} + {} = {}",n1,n2,n1+n2);
        return n1 + n2;
    }

    @Override
    public int restar(int n1, int n2) {
        logger.debug("{} + {} = {}",n1,n2,n1-n2);
        return n1 - n2;
    }

    @Override
    public int producto(int n1, int n2) {
        logger.debug("{} + {} = {}",n1,n2,n1*n2);
        return n1 * n2;
    }

    @Override
    public int division(int n1, int n2) {
        logger.debug("{} + {} = {}",n1,n2,n1/n2);
        return n1 / n2;
    }
}
