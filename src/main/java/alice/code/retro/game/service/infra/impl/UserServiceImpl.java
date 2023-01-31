package alice.code.retro.game.service.infra.impl;

import alice.code.retro.game.common.service.AbstractService;
import alice.code.retro.game.dao.infra.UserDao;
import alice.code.retro.game.service.infra.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 用户信息表Service层实现类
 * User: contact@liuxp.me
 * DateTime: 2023-01-28
 **/
@Service
public class UserServiceImpl extends AbstractService implements UserService {

    @Autowired
    public void setDao(UserDao dao) {this.iDao = dao;}

}