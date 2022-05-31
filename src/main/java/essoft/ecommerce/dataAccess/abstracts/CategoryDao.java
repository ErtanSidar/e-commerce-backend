package essoft.ecommerce.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import essoft.ecommerce.entities.concretes.Category;

@Repository
public interface CategoryDao extends JpaRepository<Category, Integer>{
	Category findByCategoryId(int CategoryId);
}
