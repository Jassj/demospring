package demo.spring.vo;

import javax.validation.constraints.NotNull;

public class LoginVo {
    /**
     *  username用户名必填
     */
    @NotNull(message = "username不能为空")
    private String username;

    /**
     *  password密码必填
     */
    @NotNull(message = "password不能为空")
    private String password;

    /**
     *  token验证码暂不校验
     */
    private String token;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "LoginVo{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", token='" + token + '\'' +
                '}';
    }
}
