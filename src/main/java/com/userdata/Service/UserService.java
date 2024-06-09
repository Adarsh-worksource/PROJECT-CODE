package com.userdata.Service;

import com.userdata.DTO.UserDTO;

import java.util.List;

public interface UserService {


    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUser(Long id, UserDTO userDTO);
    void deleteUser(Long id);
    UserDTO getUserByiD(Long id);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();


}
