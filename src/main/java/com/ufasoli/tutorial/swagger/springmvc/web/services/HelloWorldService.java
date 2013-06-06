package com.ufasoli.tutorial.swagger.springmvc.web.services;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: ufasoli
 * Date: 06/06/13
 * Time: 15:19
 * project : spring-mvc-swagger-tutorial
 */
@Controller
@RequestMapping(value = "/hello", produces = MediaType.TEXT_PLAIN_VALUE)
public class HelloWorldService {

    @RequestMapping( produces = MediaType.TEXT_PLAIN_VALUE, method = RequestMethod.GET)
    public @ResponseBody String sayHelloWorld(){

        return "Hello World!";
    }
}
