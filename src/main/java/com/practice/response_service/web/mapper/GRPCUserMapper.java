package com.practice.response_service.web.mapper;

import com.practice.grpccommon.UserProto;
import com.practice.response_service.domain.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GRPCUserMapper extends Mappable<User, UserProto>{

}
