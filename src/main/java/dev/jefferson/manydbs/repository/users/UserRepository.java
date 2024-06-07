package dev.jefferson.manydbs.repository.users;

import dev.jefferson.manydbs.model.users.Users;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<Users, String> {
}
