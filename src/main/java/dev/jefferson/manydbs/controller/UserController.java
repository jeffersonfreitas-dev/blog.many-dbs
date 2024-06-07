package dev.jefferson.manydbs.controller;

import dev.jefferson.manydbs.dto.users.UserRequest;
import dev.jefferson.manydbs.dto.users.UserResponse;
import dev.jefferson.manydbs.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponse> create(@RequestBody UserRequest request) {
        UserResponse user = userService.create(request);

        if(user == null)
            return ResponseEntity.internalServerError().build();

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{uuid}")
                .buildAndExpand(user).toUri();
        return ResponseEntity.created(location).body(user);
    }

    @GetMapping
    public ResponseEntity<List<UserResponse>> list() {
        List<UserResponse> result = userService.findAll();
        return ResponseEntity.ok().body(result);
    }
}
