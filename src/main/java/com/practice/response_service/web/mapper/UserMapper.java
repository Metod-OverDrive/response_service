package com.practice.response_service.web.mapper;

import com.practice.response_service.domain.User;
import com.practice.response_service.web.dto.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper extends Mappable<User, UserDto>{

}
