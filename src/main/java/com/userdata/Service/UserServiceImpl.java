package com.userdata.Service;

import com.userdata.DTO.UserDTO;
import com.userdata.Entity.User;
import com.userdata.Mapper.UserMapper;
import com.userdata.Repository.UserRepository;
import com.userdata.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UserServiceImpl implements UserService{

   private final UserRepository userRepository;
   private final UserMapper userMapper;

   public UserServiceImpl(UserRepository userRepository, UserMapper userMapper){
       this.userRepository = userRepository;
       this.userMapper = userMapper;
   }


    @Override
    public UserDTO createUser(UserDTO userDTO) {
       User user = userMapper.userDTOToUser(userDTO);
       User savedUser = userRepository.save(user);
        return userMapper.userToUserDTO(savedUser);
    }

    @Override
    public UserDTO updateUser(Long id, UserDTO userDTO) {
       User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
       user.setName(userDTO.getEmail());
       user.setAge(userDTO.getAge());
       user.setEmail(userDTO.getEmail());
        User updatedUser = userRepository.save(user);
        return userMapper.userToUserDTO(updatedUser);
    }


    @Override
    public void deleteUser(Long id) {
        userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        userRepository.deleteById(id);
    }

    @Override
    public UserDTO getUserByiD(Long id) {
        return null;
    }


    @Override
    public UserDTO getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with id: " + id));
        return userMapper.userToUserDTO(user);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::userToUserDTO)
                .collect(Collectors.toList());
    }
}