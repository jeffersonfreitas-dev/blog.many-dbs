package dev.jefferson.manydbs.service;

import dev.jefferson.manydbs.dto.users.UserRequest;
import dev.jefferson.manydbs.dto.users.UserResponse;
import dev.jefferson.manydbs.model.users.Users;
import dev.jefferson.manydbs.repository.users.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    @Transactional
    public UserResponse create(UserRequest request) {
        Users user = Users.create(request);
        user = userRepository.save(user);
        return UserResponse.create(user);
    }

    public List<UserResponse> findAll() {
        return userRepository.findAll().stream().map(UserResponse::create).toList();
    }
}
