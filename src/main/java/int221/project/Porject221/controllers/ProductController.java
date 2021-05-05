package int221.project.Porject221.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

import int221.project.Porject221.exceptions.ExceptionResponse;
import int221.project.Porject221.exceptions.ProductException;
import int221.project.Porject221.models.Product;
import int221.project.Porject221.repositories.ProductRepository;

@RestController
@RequestMapping("/product")
public class ProductController {
		
	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("")
	public List<Product> allProduct(){
		return productRepository.findAll();
	}
	
	@GetMapping("/page")
    public Page<Product> productWithPage(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "5") Integer pageSize,
            @RequestParam(defaultValue = "productId") String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy) );
        Page<Product> pageResult = productRepository.findAll(pageable);
        return pageResult;
    }
	
    @GetMapping("/{id}")
    public Product product(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElse(null);
        return product;
    }
    
    @PostMapping("/addproduct")
    public Product create(@RequestBody Product newProduct) {
    	if(productRepository.findById(newProduct.getProductId()).orElse(null) != null) {
    		throw new ProductException(ExceptionResponse.ERROR_CODE.ITEM_ALREADY_EXIST,
					"product id: {"+ newProduct.getProductId() + "} already exit");
    	}else if(productRepository.findByProductName(newProduct.getProductName()) != null) {
    		throw new ProductException(ExceptionResponse.ERROR_CODE.ITEM_ALREADY_EXIST,
					"product name: {"+ newProduct.getProductName() + "} already exit");
    	}
        return productRepository.save(newProduct);
    }
	
    @PutMapping("/edit/{id}")
    public Product update(@RequestPart Product updateProduct,@PathVariable Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if(productRepository.findByProductName(updateProduct.getProductName()) != null) {
    		throw new ProductException(ExceptionResponse.ERROR_CODE.ITEM_ALREADY_EXIST,
					"product name: {"+ updateProduct.getProductName() + "} already exit");
    	}
            product.setProductName(updateProduct.getProductName());
            product.setProductDescription(updateProduct.getProductDescription());
            product.setBrand(updateProduct.getBrand());
            product.setPrice(updateProduct.getPrice());
            product.setProductImage(updateProduct.getProductImage());
            product.setColorList(updateProduct.getColorList());
            
        return productRepository.save(product);
    }
    
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        Product product = productRepository.findById(id).orElse(null);
        productRepository.delete(product);
    }
	
}
