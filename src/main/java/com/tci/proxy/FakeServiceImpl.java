package com.tci.proxy;

import com.tci.service.OperationImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeServiceImpl implements FakeService {

    private static final Logger logger = LoggerFactory.getLogger(FakeServiceImpl.class);
    //private static final Logger logger = LoggerFactory.getLogger(OperationImpl.class);

    @Autowired
    private  RestTemplate restTemplate;

    @Override
    public Response query() {
        logger.debug("query");


        Response response = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/apiv2/random", Response.class);

        return response;
    }
}
