package int221.project.Porject221.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import int221.project.Porject221.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	Product findByProductName(String productName);
}
