package essoft.ecommerce.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import essoft.ecommerce.entities.concretes.Product;

@Repository
public interface ProductDao extends JpaRepository<Product, Integer> {
	Product findByProductId(int id);
}
