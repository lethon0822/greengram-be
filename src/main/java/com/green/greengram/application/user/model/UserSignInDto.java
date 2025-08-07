package com.green.greengram.application.user.model;

import com.green.greengram.config.model.JwtUser;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Builder
public class UserSignInDto {
    private UserSignInRes userSignInRes; // 응답용
    private JwtUser jwtUser; // JWT 발행용
}
