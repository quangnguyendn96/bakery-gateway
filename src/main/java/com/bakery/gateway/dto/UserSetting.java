package com.bakery.gateway.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserSetting {
    private String username;
    private String password;
}
