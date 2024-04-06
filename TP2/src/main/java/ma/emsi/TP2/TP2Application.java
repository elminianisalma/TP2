package ma.emsi.TP2;

import ma.emsi.TP2.entities.Product;
import ma.emsi.TP2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Optional;

@SpringBootApplication
public class TP2Application implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;

    public static void main(String[] args) {
        SpringApplication.run(TP2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Ajouter des produits
        Product product1 = new Product(null, "Produit 1", 15.5, 50);
        productRepository.save(product1);
        Product product2 = new Product(null, "Produit 2", 50.3, 20);
        productRepository.save(product2);
        Product product3 = new Product(null, "Produit 3", 51.4, 30);
        productRepository.save(product3);

        // Consulter un seul produit par son ID
        Long productIdToFind = 1L;
        Optional<Product> productFoundOptional = productRepository.findById(productIdToFind);

        // Vérifier si le produit a été trouvé
        if (productFoundOptional.isPresent()) {
            Product productFound = productFoundOptional.get();
            System.out.println("Produit trouvé : " + productFound);

        // Mettre à jour un produit
        Optional<Product> productToUpdateOptional = productRepository.findById(1L);
        if (productToUpdateOptional.isPresent()) {
            Product productToUpdate = productToUpdateOptional.get();
            productToUpdate.setName("Nouveau nom du produit");
            productRepository.save(productToUpdate);
        }

        // Supprimer un produit
        productRepository.deleteById(2L);
    }

    }
}
