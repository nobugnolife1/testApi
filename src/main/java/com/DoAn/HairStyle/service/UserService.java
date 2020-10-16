package com.DoAn.HairStyle.service;

import com.DoAn.HairStyle.dto.*;
import com.DoAn.HairStyle.entity.UserEntity;
import com.DoAn.HairStyle.respositiry.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRespository userRespository;

    public void insertUser(UserEntity user) {
        UserEntity userAdd = new UserEntity();
        userAdd.setToken(UUID.randomUUID().toString());
        userAdd.setAddress(user.getAddress());
        userAdd.setRole(user.getRole());
        userAdd.setFullName(user.getFullName());
        userAdd.setNumberPhone(user.getNumberPhone());
        userAdd.setPassWord(user.getPassWord());
        userRespository.save(userAdd);
    }

    public AuthResponse login(LoginRequest loginRequest) {
        UserEntity userLogin = userRespository.findByNumberPhone(loginRequest.getNumberPhone());
        AuthResponse authResponse = new AuthResponse();
        authResponse.setAuthenticationToken(userLogin.getToken());
        return authResponse;
    }

    public Response deleteByToken(String token) {
        userRespository.deleteByToken(token);
        Response response  = new Response();
        response.setStatus("Success!");
        return response;
    }

    public Response updateUser(String token, UpdateUserRequest updateUserRequest) {
        UserEntity userAdd = new UserEntity();
        userAdd.setToken(token);
        userAdd.setAddress(updateUserRequest.getAddress());
        userAdd.setFullName(updateUserRequest.getFullName());
        userAdd.setRole(updateUserRequest.getRole());
        userAdd.setNumberPhone(updateUserRequest.getNumberPhone());
        userAdd.setPassWord(updateUserRequest.getPassWord());
        userRespository.save(userAdd);
        Response response  = new Response();
        response.setStatus("Success!");
        return response;
    }
}
