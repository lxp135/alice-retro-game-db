package alice.code.retro.game.service.infra.impl;

import alice.code.retro.game.common.service.AbstractService;
import alice.code.retro.game.dao.infra.RoleUserRelDao;
import alice.code.retro.game.service.infra.RoleUserRelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色与用户关系表Service层实现类
 * User: contact@liuxp.me
 * DateTime: 2023-01-28
 **/
@Service
public class RoleUserRelServiceImpl extends AbstractService implements RoleUserRelService {

    @Autowired
    public void setDao(RoleUserRelDao dao) {this.iDao = dao;}

}