package alice.code.retro.game.service.infra.impl;

import alice.code.retro.game.common.service.AbstractService;
import alice.code.retro.game.dao.infra.RoleMenuRelDao;
import alice.code.retro.game.service.infra.RoleMenuRelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色与菜单关系表Service层实现类
 * User: contact@liuxp.me
 * DateTime: 2023-01-28
 **/
@Service
public class RoleMenuRelServiceImpl extends AbstractService implements RoleMenuRelService {

    @Autowired
    public void setDao(RoleMenuRelDao dao) {this.iDao = dao;}

}