package br.sp.fatec.product.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.sp.fatec.product.entities.Product;
import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("products")

public class ProductController { //cria o controller

    private ArrayList<Product> list = new ArrayList<Product>(); //cria uma lista

    public ProductController() { //cria os produtos
        list.add(new Product(1L, "Produto 1", "Descrição 1", 10.0));
        list.add(new Product(2L, "Produto 2", "Descrição 2", 20.0));
        list.add(new Product(3L, "Produto 3", "Descrição 3", 30.0));
    }
    @GetMapping 
    public List<Product> getProducts () //retorna a lista
        {
            return list;
        }

    @GetMapping("{id}")
        public Product getProductById(@PathVariable long id) {
            return list.stream()
                 .filter( p -> p.getId() == id) //procura o id no arry e mostra na tela
                 .findFirst()
                 .orElseThrow( () -> new EntityNotFoundException("Não cadastrado")); //erro quando não achar nenhum id
    }

}
