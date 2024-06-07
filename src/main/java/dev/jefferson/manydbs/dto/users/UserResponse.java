package dev.jefferson.manydbs.dto.users;

import dev.jefferson.manydbs.model.users.Users;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String uuid;
    private String name;

    public static UserResponse create(Users entity) {
        return new UserResponse(entity.getUuid(), entity.getName());
    }
}
