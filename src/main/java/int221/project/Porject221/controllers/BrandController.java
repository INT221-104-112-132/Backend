package int221.project.Porject221.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import int221.project.Porject221.models.Brand;
import int221.project.Porject221.repositories.BrandRepository;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    private BrandRepository brandRepository;

    @GetMapping("")
    public List<Brand> brands() {
        return brandRepository.findAll();
    }

    @GetMapping("/{id}")
    public Brand brands(@PathVariable Long id) {
        return brandRepository.findById(id).orElseThrow(null);
    }

}