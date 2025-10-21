package br.sp.fatec.product.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.fatec.product.entities.Product;
import br.sp.fatec.product.repositories.ProductRepository;

@RestController
@RequestMapping("products")

public class ProductController { //cria o controller

    @Autowired
    private ProductRepository repository;
    @GetMapping 
    public List<Product> getProducts () //devolve todos produtos
        {
            return repository.findAll();
        }

}
