package com.bakery.gateway.grpc.config;

import com.bakery.account.proto.UsersSettingServiceGrpc;
import io.grpc.ManagedChannel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AccountGrpcStubConfig {

    private final SadlierGrpcSlowQueryDetectingInterceptor loggingClientInterceptor;

    public AccountGrpcStubConfig(SadlierGrpcSlowQueryDetectingInterceptor loggingClientInterceptor) {
        this.loggingClientInterceptor = loggingClientInterceptor;
    }
    @Bean
    public UsersSettingServiceGrpc.UsersSettingServiceBlockingStub usersSettingServiceBlockingStub(@Qualifier("AccountGrpcChannel") ManagedChannel channel) {
        return UsersSettingServiceGrpc.newBlockingStub(channel)
                .withInterceptors(loggingClientInterceptor);
    }
}
