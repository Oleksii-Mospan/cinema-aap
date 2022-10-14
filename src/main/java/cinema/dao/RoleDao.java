package cinema.dao;

import cinema.model.Role;
import java.util.List;
import java.util.Optional;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getByName(String roleName);

    List<Role> getAll();

    Optional<Role> get(Long id);
}
