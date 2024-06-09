package com.userdata.config;


import com.userdata.DTO.UserDTO;
import com.userdata.Entity.User;
import com.userdata.Mapper.UserMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public UserMapper userMapper() {
        return new UserMapper() {

            @Override
            public UserDTO userToUserDTO(User user) {
                UserDTO userDTO = new UserDTO();
                // Map properties from User to UserDTO
                userDTO.setId(user.getId());
                userDTO.setName(user.getName());
                userDTO.setEmail(user.getEmail());
                userDTO.setAge(user.getAge());

                return userDTO;
            }

            @Override
            public User userDTOToUser(UserDTO userDTO) {
                User user = new User();
                // Map properties from UserDTO to User
                user.setId(userDTO.getId());
                user.setAge(userDTO.getAge());
                user.setEmail(userDTO.getEmail());
                user.setName(userDTO.getName());
                // Add other mappings as needed
                return user;
            }
        };
    }
}