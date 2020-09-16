package com.github.tricks.pojo;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author 石少东
 * @date 2020-09-16 21:52
 * @since 1.0
 */


@Getter
@Setter
@ToString
public class UserInfoDTO {

    private String username;

    @JsonView(IUserRequestView.class)
    private String password;

    @JsonView({IUserRequestView.class, IUserResponseView.class})
    private Integer age;

    public interface IUserRequestView {
    }

    public interface IUserResponseView {
    }

}
