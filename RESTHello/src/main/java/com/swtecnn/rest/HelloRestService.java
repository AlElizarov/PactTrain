package com.swtecnn.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@ComponentScan
public class HelloRestService{

    @Autowired
    BookLogic bl;

    @RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
    ResponseEntity<Book> home(@PathVariable("id") long id) {
        return new ResponseEntity<Book>(bl.getBookById(id), HttpStatus.OK);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloRestService.class, args);
    }
}
