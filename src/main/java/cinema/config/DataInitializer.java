package cinema.config;

import cinema.model.Role;
import cinema.model.User;
import cinema.service.AuthenticationService;
import cinema.service.RoleService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Service;

@Service
public class DataInitializer {
    private final AuthenticationService authService;
    private final RoleService roleService;

    public DataInitializer(AuthenticationService authService, RoleService roleService) {
        this.authService = authService;
        this.roleService = roleService;
    }

    @PostConstruct
    public void inject() {
        Role userRole = new Role();
        userRole.setName(Role.RoleName.USER);
        roleService.add(userRole);
        Role adminRole = new Role();
        adminRole.setName(Role.RoleName.ADMIN);
        roleService.add(adminRole);

        User bob = new User();
        bob.setEmail("bob@gmail.com");
        bob.setPassword("12345678");
        bob.setRoles(Set.of(roleService.getByName(Role.RoleName.USER.name())));
        authService.register(bob);

        User alice = new User();
        alice.setEmail("alice@gmail.com");
        alice.setPassword("12345678");
        alice.setRoles(Set.of(roleService.getByName(Role.RoleName.USER.name())));
        authService.register(alice);

        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("12345678");
        admin.setRoles(Set.of(roleService.getByName(Role.RoleName.USER.name()),
                roleService.getByName(Role.RoleName.ADMIN.name())));
        authService.register(admin);
    }
}
