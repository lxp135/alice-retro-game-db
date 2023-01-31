package alice.code.retro.game.service.infra.impl;

import alice.code.retro.game.domain.model.Account;
import alice.code.retro.game.domain.model.infra.User;
import alice.code.retro.game.service.infra.AuthService;
import alice.code.retro.game.service.infra.UserService;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.crypto.SecureUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 用户信息表Service层实现类
 * User: contact@liuxp.me
 * DateTime: 2023-01-28
 **/
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    UserService userService;

    @Override
    public Account login(String account, String password) {

        User userQuery = new User();
        userQuery.setUserAccount(account);
        User user = userService.selectOne(userQuery);

        if(null==user){
            throw new IllegalArgumentException(account+"账号不存在");
        }

        if(!user.getIsEnable()){
            throw new IllegalArgumentException(account+"账号已被禁用");
        }

        if(!SecureUtil.sha256(password).equals(user.getUserPassword())){
            throw new IllegalArgumentException("密码错误");
        }

        // 登录
        StpUtil.login(user.getId());

        Account result = new Account();
        result.setId(user.getId());
        result.setUserAccount(user.getUserAccount()); // 用户账号
        result.setUserName(user.getUserName()); // 用户名称
        result.setUserSex(user.getUserSex()); // 性别
        result.setUserFace(user.getUserFace()); // 头像
        result.setUserEmail(user.getUserEmail()); // 电子邮件
        result.setUserWechat(user.getUserWechat()); // 微信号
        result.setUserPhone(user.getUserPhone()); // 手机号

        return result;
    }
}