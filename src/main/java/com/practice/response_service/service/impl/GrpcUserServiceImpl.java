package com.practice.response_service.service.impl;

import com.google.protobuf.Empty;
import com.practice.grpccommon.UserProto;
import com.practice.grpccommon.UserServiceGrpc;
import com.practice.response_service.domain.User;
import com.practice.response_service.service.UserService;
import com.practice.response_service.web.mapper.GRPCUserMapper;
import io.grpc.stub.StreamObserver;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.server.service.GrpcService;

import java.util.List;

@GrpcService
@RequiredArgsConstructor
public class GrpcUserServiceImpl extends UserServiceGrpc.UserServiceImplBase {

    private final UserService userService;
    private final GRPCUserMapper userMapper;

    @Override
    public void create(UserProto request, StreamObserver<UserProto> responseObserver) {
        User user = userMapper.toEntity(request);
        User updateUser = userService.create(user);
        responseObserver.onNext(createUserProto(updateUser));
        responseObserver.onCompleted();
    }

    @Override
    public void getAllUsers(Empty request, StreamObserver<UserProto> responseObserver) {
        List<User> users = userService.getAll();
        users.stream()
                .map(GrpcUserServiceImpl::createUserProto)
                .forEach(responseObserver::onNext);
        responseObserver.onCompleted();
    }

    private static UserProto createUserProto(User user) {
        return UserProto.newBuilder()
                .setId(user.getId())
                .setName(user.getName())
                .setCourse(user.getCourse())
                .build();
    }

}
