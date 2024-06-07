package dev.jefferson.manydbs.model.users;


import dev.jefferson.manydbs.dto.users.UserRequest;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "users")
@NoArgsConstructor
@AllArgsConstructor
public class Users {

    @Id
    private String uuid;

    private String name;

    public static Users create(UserRequest request) {
        return new Users(UUID.randomUUID().toString(), request.getName());
    }
}
