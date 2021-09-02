package com.earthquake.managementPlatform.service;

public interface UserInfoUpdateService {
    int updateUsername(String newUsername, String oldUsername);
    int updatePassword(String password, String username);
}
