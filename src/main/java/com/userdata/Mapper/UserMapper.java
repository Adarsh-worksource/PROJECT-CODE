package com.userdata.Mapper;
import  org.mapstruct.Mapper;

import com.userdata.DTO.UserDTO;
import com.userdata.Entity.User;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO userToUserDTO(User user);
    User userDTOToUser(UserDTO userDTO);

}
