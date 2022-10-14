package cinema.service;

import cinema.model.Role;
import java.util.List;

public interface RoleService {
    Role add(Role role);

    Role getByName(String roleName);

    List<Role> getAll();
}
