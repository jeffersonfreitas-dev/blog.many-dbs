package dev.jefferson.manydbs.controller;

import dev.jefferson.manydbs.dto.product.ProductRequest;
import dev.jefferson.manydbs.dto.product.ProductResponse;
import dev.jefferson.manydbs.dto.sales.SalesRequest;
import dev.jefferson.manydbs.dto.sales.SalesResponse;
import dev.jefferson.manydbs.service.ProductService;
import dev.jefferson.manydbs.service.sales.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductRequest request) {
        ProductResponse result = productService.create(request);

        if(result == null)
            return ResponseEntity.internalServerError().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}")
                .buildAndExpand(result.getUuid()).toUri();
        return ResponseEntity.created(location).body(result);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> list() {
        List<ProductResponse> result = productService.findAll();
        return ResponseEntity.ok().body(result);
    }
}
