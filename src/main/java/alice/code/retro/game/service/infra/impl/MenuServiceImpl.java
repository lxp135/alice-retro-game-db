package alice.code.retro.game.service.infra.impl;

import alice.code.retro.game.common.service.AbstractService;
import alice.code.retro.game.dao.infra.MenuDao;
import alice.code.retro.game.domain.model.infra.RoleMenuRel;
import alice.code.retro.game.service.infra.MenuService;

import alice.code.retro.game.service.infra.RoleMenuRelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单基本信息表Service层实现类
 * User: contact@liuxp.me
 * DateTime: 2023-01-28
 **/
@Service
public class MenuServiceImpl extends AbstractService implements MenuService {

    @Autowired
    public void setDao(MenuDao dao) {this.iDao = dao;}

    @Resource
    private RoleMenuRelService roleMenuRelService;

    @Override
    @Transactional
    public int delete(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("参数id不能为null");
        }

        int deleteCount = super.delete(id);
        if (deleteCount > 0) {
            // 删除菜单与角色绑定关系
            RoleMenuRel baseRoleMenuRelQuery = new RoleMenuRel();
            baseRoleMenuRelQuery.setMenuId(id);
            List<RoleMenuRel> baseRoleMenuRelList = roleMenuRelService.selectList(baseRoleMenuRelQuery);
            for (RoleMenuRel baseRoleMenuRel : baseRoleMenuRelList) {
                roleMenuRelService.delete(baseRoleMenuRel.getId());
            }
        }

        return deleteCount;
    }
}