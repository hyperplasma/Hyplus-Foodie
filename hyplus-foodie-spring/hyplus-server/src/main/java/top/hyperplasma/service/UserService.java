package top.hyperplasma.service;

import top.hyperplasma.dto.UserLoginDTO;
import top.hyperplasma.entity.User;

public interface UserService {

    /**
     * 微信登录
     * @param userLoginDTO
     * @return User
     */
    User wxLogin(UserLoginDTO userLoginDTO);
}
