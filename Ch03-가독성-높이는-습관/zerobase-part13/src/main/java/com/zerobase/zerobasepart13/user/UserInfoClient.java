package com.zerobase.zerobasepart13.user;

import java.util.Optional;

public interface UserInfoClient {
    Optional<UserInfo> findUserInfo(Long id);
}
