package ma.emsi.TP2.repository;

import ma.emsi.TP2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("SELECT p FROM Product p WHERE p.price = :price")
    List<Product> findByPrice(@Param("price") double price);

    Optional<Product> findById(Long id);
}
