package br.com.yuri.dailydev.mapper;

import br.com.yuri.dailydev.dto.request.UserRequest;
import br.com.yuri.dailydev.dto.response.UserResponse;
import br.com.yuri.dailydev.model.User;
import lombok.experimental.UtilityClass;

@UtilityClass
public class UserMapper {

    public static User toUser(UserRequest userRequest){

        return User.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .password(userRequest.password())
                .build();
    }

    public static UserResponse toUserResponse(User user){
        return UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .build();
    }
}
