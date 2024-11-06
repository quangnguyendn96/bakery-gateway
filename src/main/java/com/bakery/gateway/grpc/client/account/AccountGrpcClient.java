package com.bakery.gateway.grpc.client.account;

import com.bakery.account.proto.UserSettingResponse;
import com.bakery.gateway.dto.UserSetting;

public interface AccountGrpcClient {
    UserSettingResponse createUser(UserSetting userSetting);
}
