package com.bakery.gateway.controller;

import com.bakery.account.proto.UserSettingRequest;
import com.bakery.account.proto.UserSettingResponse;
import com.bakery.gateway.dto.UserSetting;
import com.bakery.gateway.grpc.client.account.AccountGrpcClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
public class AccountController {
    private final AccountGrpcClient accountGrpcClient;
    @PostMapping("/create")
    public ResponseEntity createUser(@RequestBody UserSetting userSetting){
        UserSettingResponse res = accountGrpcClient.createUser(userSetting);
        if(res.getSuccess()){
            return new ResponseEntity<>("Oke", HttpStatus.CREATED);
        }
        else  {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
