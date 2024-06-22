package aicha.pfe.tasks.service.role;

import aicha.pfe.tasks.entity.Role;
import aicha.pfe.tasks.repository.RoleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class RoleServiceImpl implements IRoleService {
    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> retrieve() {
        return (List<Role>) roleRepository.findAll();
    }

    @Override
    public Role add(Role role) {
        roleRepository.save(role);
        return role;
    }

    @Override
    public void delete(Long id) {
        roleRepository.deleteById(id);
    }

    @Override
    public Role update(Role role) {
        roleRepository.save(role);
        return role;
    }

}
