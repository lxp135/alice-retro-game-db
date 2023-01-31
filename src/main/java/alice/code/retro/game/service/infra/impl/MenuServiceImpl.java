package alice.code.retro.game.service.infra.impl;

import alice.code.retro.game.common.service.AbstractService;
import alice.code.retro.game.dao.infra.MenuDao;
import alice.code.retro.game.service.infra.MenuService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 菜单基本信息表Service层实现类
 * User: contact@liuxp.me
 * DateTime: 2023-01-28
 **/
@Service
public class MenuServiceImpl extends AbstractService implements MenuService {

    @Autowired
    public void setDao(MenuDao dao) {this.iDao = dao;}

}