package com.kodluyoruz.emlakcepte.controller;

import com.kodluyoruz.emlakcepte.model.Realty;
import com.kodluyoruz.emlakcepte.service.RealtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/realties")
public class RealtyController {

    @Autowired
    private RealtyService realtyService;

    @GetMapping
    public List<Realty> getAll(){
        return realtyService.getAll();
    }

    @PostMapping
    public ResponseEntity<Realty> create(@RequestBody Realty realty){
        System.out.println("realty" + realty);
        realtyService.create(realty);
        return new ResponseEntity<>(realty, HttpStatus.CREATED);
    }
}
