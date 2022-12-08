package com.cashcall.merchant.MerchantService.Auth;

import com.cashcall.merchant.Model.Role;
import com.cashcall.merchant.Model.User;
import com.cashcall.merchant.Repository.Auth.RoleRepository;
import com.cashcall.merchant.Repository.Auth.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j // Slf4j => The Simple Logging Facade for Java
public class UserServiceImplementation implements UserService {


    @Autowired
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;


    @Override
    public User SaveUser(User user) {
        // log.info("Saving new user: "+ user.getName() + " to database");
        log.info("Saving new user: {} to database", user.getId());
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        // log.info("Saving new role: " + role.getName() + " to database");
        log.info("Saving new role: {} to database", role.getId());

        return roleRepository.save(role);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Adding role: {} to user: {} ", roleName, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(username);

        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Fetching user: {} form DB", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public List<User> getUsers() {
        log.info("Fetching users: form DB");
        return userRepository.findAll();
    }
}



