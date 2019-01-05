package com.swtecnn.rest;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class BookLogic {

    public Book getBookById(long id){
        if(id == 1){
            return new Book("Tolstoi", "War and Piece");
        }
        return new Book("Pushkin", "Onegin");
    }

}
