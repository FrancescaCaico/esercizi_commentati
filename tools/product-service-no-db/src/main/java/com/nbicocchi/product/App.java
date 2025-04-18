package com.nbicocchi.product;

import com.nbicocchi.product.persistence.model.Product;
import com.nbicocchi.product.persistence.repository.ProductRepository;
import lombok.extern.java.Log;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
Questa annotazione è un composto di tre annotazioni: @Configuration, @EnableAutoConfiguration, e @ComponentScan.
Segnala a Spring Boot che questa classe è il punto di partenza per l'applicazione e abilita l'autoconfigurazione.

Implementando ApplicationRunner, la classe App può eseguire codice specifico subito dopo che l'applicazione è avviata.
Ciò è utile per eseguire logica di inizializzazione, come il caricamento di dati di esempio.

IL METODO RUN è IL PRIMO METODO CHE VIENE CHIAMATO E IN CUI vengono creati tre oggetti Product e salvati nel ProductRepository iniettato tramite costruttore. Ogni prodotto ha un identificativo, un nome e un prezzo.
Successivamente, tutti i prodotti salvati vengono recuperati tramite findAll() e il loro contenuto viene stampato nel log utilizzando log.info()
**/

@Log // usiamo lombok per loggare le operazioni eseguite
@SpringBootApplication
public class App implements ApplicationRunner {
    ProductRepository productRepository;

    public App(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public static void main(final String... args) {
        SpringApplication.run(App.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        productRepository.save(new Product("171f5df0-b213-4a40-8ae6-fe82239ab660", "Laptop", 2.2));
        productRepository.save(new Product("f89b6577-3705-414f-8b01-41c091abb5e0", "Bike", 5.5));
        productRepository.save(new Product("b1f4748a-f3cd-4fc3-be58-38316afe1574", "Shirt", 0.2));

        productRepository.findAll().forEach(product -> log.info(product.toString()));
    }
}
