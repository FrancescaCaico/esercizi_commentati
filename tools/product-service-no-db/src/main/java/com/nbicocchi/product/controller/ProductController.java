package com.nbicocchi.product.controller;

import com.nbicocchi.product.persistence.model.Product;
import com.nbicocchi.product.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;


/*
IL CONTROLLER DEFINISCE GLI ENTRYPOINT CON CUI L'UTENTE PUò INTERAGIRE CON IL SERVIZIO. IN QUESTO CASO LA CLASSE è ANNOTATA COME
@RestController:
L'annotazione @RestController in Spring è una combinazione di due annotazioni: @Controller e @ResponseBody.
Viene utilizzata nelle applicazioni Spring per definire un controller, che è responsabile dell'elaborazione
delle richieste HTTP e della restituzione di risposte. Questa annotazione è comunemente usata nelle applicazioni web basate su REST,
dove i dati vengono restituiti in formati come JSON o XML.
Questa annotazione è propria di import org.springframework.web.bind.annotation.*;
*/

@RestController
@RequestMapping("/products")
public class ProductController {
    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/{uuid}")
    public Product findByUuid(@PathVariable String uuid) {
        return productService.findByUuid(uuid).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping
    public Iterable<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping
    public Product create(@RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/{uuid}")
    public Product update(@PathVariable String uuid, @RequestBody Product product) {
        Optional<Product> optionalProject = productService.findByUuid(uuid);
        optionalProject.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        product.setId(optionalProject.get().getId());
        return productService.save(product);
    }

    @DeleteMapping("/{uuid}")
    public void delete(@PathVariable String uuid) {
        Optional<Product> optionalProject = productService.findByUuid(uuid);
        optionalProject.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        productService.delete(optionalProject.get());
    }
}