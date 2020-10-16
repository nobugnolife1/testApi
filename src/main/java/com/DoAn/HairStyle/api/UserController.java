package com.DoAn.HairStyle.api;


import com.DoAn.HairStyle.dto.*;
import com.DoAn.HairStyle.entity.BlogEntity;
import com.DoAn.HairStyle.entity.UserEntity;
import com.DoAn.HairStyle.respositiry.BlogRespository;
import com.DoAn.HairStyle.respositiry.UserRespository;
import com.DoAn.HairStyle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private final UserService userService;
//    @Autowired
//    private BlogRespository blogRespository;

    @Autowired
    private UserRespository userRespository;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@Valid @NonNull @RequestBody UserEntity user){
        userService.insertUser(user);
    }

    @GetMapping
    public List<UserEntity> getAllUser(){
        return userRespository.findAll();
    }

    @PostMapping(path = "{login}")
    public AuthResponse login(@Valid @NonNull @RequestBody LoginRequest loginRequest){
        return userService.login(loginRequest);
    }

    @GetMapping(path = "{token}")
    public UserEntity getUserByToken(@PathVariable("token") String token){
        return userRespository.findByToken(token);
    }
    @PutMapping(path = "/update/{token}")
    public Response updateUser( @Valid @NonNull @RequestBody UpdateUserRequest updateUserRequest ,@PathVariable("token") String token){
        return userService.updateUser(token,updateUserRequest);
    }
    @DeleteMapping(path = "/delete/{token}")
    public Response deleteUser(@PathVariable("token") String token){
        return userService.deleteByToken(token);
    }


}
