package dev.jefferson.manydbs.controller;

import dev.jefferson.manydbs.dto.sales.SalesRequest;
import dev.jefferson.manydbs.dto.sales.SalesResponse;
import dev.jefferson.manydbs.service.sales.SalesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/sales")
@RequiredArgsConstructor
public class SalesController {

    private final SalesService salesService;

    @PostMapping
    public ResponseEntity<SalesResponse> create(@RequestBody SalesRequest request) {
        SalesResponse result = salesService.create(request);

        if(result == null)
            return ResponseEntity.internalServerError().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}")
                .buildAndExpand(result.getUuid()).toUri();
        return ResponseEntity.created(location).body(result);
    }

    @GetMapping
    public ResponseEntity<List<SalesResponse>> list() {
        List<SalesResponse> result = salesService.findAll();
        return ResponseEntity.ok().body(result);
    }
}
