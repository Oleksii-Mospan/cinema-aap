package cinema.lib;

import cinema.service.RoleService;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class RoleValidator implements ConstraintValidator<ValidRoles, List<String>> {
    private final RoleService roleService;

    public RoleValidator(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public boolean isValid(List<String> roleNames, ConstraintValidatorContext context) {
        Set<String> savedRoleNames = roleService.getAll().stream()
                .map(role -> role.getName().name())
                .collect(Collectors.toSet());
        Set<String> comparedRoleNames = new HashSet<>(roleNames);
        return savedRoleNames.containsAll(comparedRoleNames);
    }
}
