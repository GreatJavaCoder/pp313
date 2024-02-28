package ru.komm.pp313.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.komm.pp313.model.Role;
import ru.komm.pp313.repository.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
