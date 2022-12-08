package com.cashcall.merchant.MerchantService.Auth;

import com.cashcall.merchant.Model.Role;
import com.cashcall.merchant.Model.User;

import java.util.List;


public interface UserService {

    User SaveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);

    List<User> getUsers();


}
