package com.bakery.gateway.grpc.config;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

/**
 * @author duynt on 10/27/21
 */
@Configuration
@RequiredArgsConstructor
@SuppressWarnings("unused")
public class GrpcChannelConfig {

    private final Environment environment;

    @Value("${sadlier.grpc.client.common.max.message.inbound.size}")
    private Integer commonMessageSize;

    @Bean("AccountGrpcChannel")
    public ManagedChannel accountGrpcChannel() {
        var messageSize = environment
            .getRequiredProperty("sadlier.grpc.client.account.message.size", Integer.class);
        return ManagedChannelBuilder.forAddress(
            environment.getRequiredProperty("sadlier.grpc.client.account.host"),
            environment.getRequiredProperty("sadlier.grpc.client.account.port", Integer.class))
            .usePlaintext()
            .maxInboundMessageSize(messageSize * 1024 * 1024) //  default 4MB if not any change
            .build();
    }
    @Bean
    public SadlierGrpcSlowQueryDetectingInterceptor grpcExecLoggingClientInterceptor(
            Environment environment) {
        long slowGrpcCallThreshold = environment
                .getRequiredProperty("sadlier.grpc.log_call_slower_than_ms", Long.class);
        return new SadlierGrpcSlowQueryDetectingInterceptor(slowGrpcCallThreshold);
    }
}
