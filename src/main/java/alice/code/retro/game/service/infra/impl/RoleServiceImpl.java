package alice.code.retro.game.service.infra.impl;

import alice.code.retro.game.common.service.AbstractService;
import alice.code.retro.game.dao.infra.RoleDao;
import alice.code.retro.game.service.infra.RoleService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色基本信息表Service层实现类
 * User: contact@liuxp.me
 * DateTime: 2023-01-28
 **/
@Service
public class RoleServiceImpl extends AbstractService implements RoleService {

    @Autowired
    public void setDao(RoleDao dao) {this.iDao = dao;}

}