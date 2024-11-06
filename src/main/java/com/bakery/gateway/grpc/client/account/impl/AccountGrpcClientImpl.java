package com.bakery.gateway.grpc.client.account.impl;

import com.bakery.account.proto.UserSettingRequest;
import com.bakery.account.proto.UserSettingResponse;
import com.bakery.account.proto.UsersSettingServiceGrpc;
import com.bakery.gateway.dto.UserSetting;
import com.bakery.gateway.grpc.client.account.AccountGrpcClient;
import org.springframework.stereotype.Service;

@Service
public class AccountGrpcClientImpl implements AccountGrpcClient {

    private UsersSettingServiceGrpc.UsersSettingServiceBlockingStub usersSettingServiceBlockingStub;

    public AccountGrpcClientImpl(UsersSettingServiceGrpc.UsersSettingServiceBlockingStub usersSettingServiceBlockingStub) {
        this.usersSettingServiceBlockingStub = usersSettingServiceBlockingStub;
    }
    public UserSettingResponse createUser(UserSetting userSetting){
        return usersSettingServiceBlockingStub.createUser(
                UserSettingRequest.newBuilder()
                        .setRoleName(userSetting.getUserName())
                        .setUserName(userSetting.getUserName())
                        .build());
    }
}
