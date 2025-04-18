package com.nbicocchi.product.persistence.repository;
import com.nbicocchi.product.persistence.model.Product;
import org.springframework.stereotype.Repository;
import java.util.*;

/*
"""
IMPLEMENTAZIONE DELLE OPERAZIONI CRUD SULL'ENTITA' IN QUESTO CASO SICCOME NON C'è IL DB NON è PRESENTE LA DIPENDENZA JPA DI SPRING QUINDI BASTA INSERIRE SOLO L'ANNOTAZIONE @Repository PER FAR SI CHE FUNZIONI.
"""
*/

@Repository
public class ProductRepository {
    private final List<Product> products = new ArrayList<>();

 /*   """
    La classe Optional in Java è una parte del pacchetto java.util introdotta con Java 8. È stata progettata per rappresentare
    un valore che può essere presente (cioè un valore valido) o assente (null). Optional è una soluzione per il problema
    del "NullPointerException", che è molto comune quando si lavora con valori che possono essere null.
    """*/

    // SI FILTRA PER L'ID ASSOCIATO EVENTUALMENTE AL PRODOTTO
    public Optional<Product> findById(Long id) {
        return products.stream().filter(p -> p.getId().equals(id)).findFirst();
    }

    // SI FILTRA PER L'UUID ASSOCIATO EVENTUALMENTE AL PRODOTTO CHE è LA CHIAVE PRIMARIA
    public Optional<Product> findByUuid(String uuid) {
        return products.stream().filter(p -> p.getUuid().equals(uuid)).findFirst();
    }

    // SI RICAVANO TUTTI I PRODOTTI.
    public Iterable<Product> findAll() {
        return products;
    }


    public Product save(Product product) {

        Product toSave = new Product(
                product.getId(),
                product.getUuid(),
                product.getName(),
                product.getWeight()
        );

        if (Objects.isNull(toSave.getId())) {
            toSave.setId(new Random().nextLong(1_000_000L));
        }

        Optional<Product> existingProject = findById(product.getId());
        existingProject.ifPresent(products::remove);
        products.add(toSave);

        return toSave;
    }

    public void delete(Product product) {
        products.remove(product);
    }
}
