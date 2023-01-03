package com.my.restapi.model;

import com.my.restapi.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserModel {
    private Long id;
    private String username;

    public static UserModel toModel(User user){
        UserModel userModel = new UserModel();
        userModel.setId(user.getId());
        userModel.setUsername(user.getUsername());
        return userModel;
    }
}
