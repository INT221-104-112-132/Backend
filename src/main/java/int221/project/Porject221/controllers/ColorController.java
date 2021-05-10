package int221.project.Porject221.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import int221.project.Porject221.models.Color;
import int221.project.Porject221.repositories.ColorRepository;

import java.util.List;

@RestController
@RequestMapping("/color")
public class ColorController {
    @Autowired
    private ColorRepository colorRepository;

    @GetMapping("")
    public List<Color> brands() {
        return colorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Color colors(@PathVariable Long id) {
        return colorRepository.findById(id).orElseThrow(null);
    }

}
