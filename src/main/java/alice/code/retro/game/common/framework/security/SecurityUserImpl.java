package alice.code.retro.game.common.framework.security;

import alice.code.retro.game.domain.model.infra.Menu;
import alice.code.retro.game.domain.model.infra.Role;
import alice.code.retro.game.domain.model.infra.RoleMenuRel;
import alice.code.retro.game.domain.model.infra.RoleUserRel;
import alice.code.retro.game.service.infra.MenuService;
import alice.code.retro.game.service.infra.RoleMenuRelService;
import alice.code.retro.game.service.infra.RoleService;
import alice.code.retro.game.service.infra.RoleUserRelService;
import cn.dev33.satoken.stp.StpInterface;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 自定义权限验证接口扩展
 */
@Component    // 保证此类被SpringBoot扫描，完成Sa-Token的自定义权限验证扩展
public class SecurityUserImpl implements StpInterface {

    // 公共资源码，通用接口权限使用该编码
    private final static String KEY_PUBLIC_AUTHORITY = "PUBLIC";

    @Resource
    RoleUserRelService roleUserRelService;

    @Resource
    RoleService roleService;

    @Resource
    RoleMenuRelService roleMenuRelService;

    @Resource
    MenuService menuService;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {

        List<Menu> baseMenus = new ArrayList<>(); // 当前用户当前角色菜单列表

        // 查询用户所属角色列表
        RoleUserRel baseRoleUserRelQuery = new RoleUserRel();
        baseRoleUserRelQuery.setUserId(Long.valueOf(String.valueOf(loginId)));
        List<RoleUserRel> baseRoleUserRels = roleUserRelService.selectList(baseRoleUserRelQuery);
        if(baseRoleUserRels.size()>0){

            Set<Long> menuIds = new HashSet<>();

            for (RoleUserRel baseRoleUserRel : baseRoleUserRels){

                // 查询当前用户菜单列表
                RoleMenuRel systemBaseRoleMenuRelQuery = new RoleMenuRel();
                systemBaseRoleMenuRelQuery.setRoleId(baseRoleUserRel.getRoleId());
                List<RoleMenuRel> systemBaseRoleMenuRels = roleMenuRelService.selectList(systemBaseRoleMenuRelQuery);

                for(RoleMenuRel baseRoleMenuRel : systemBaseRoleMenuRels){
                    menuIds.add(baseRoleMenuRel.getMenuId());
                }

            }

            for(Long menuId:menuIds){
                Menu baseMenu = menuService.selectOne(menuId);
                baseMenus.add(baseMenu);
            }

        }

        List<String> authorityList = new ArrayList<>();
        authorityList.add(KEY_PUBLIC_AUTHORITY);
        for (Menu menu : baseMenus) {
            authorityList.add(menu.getMenuKey());
        }
        return authorityList;
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {

        List<Role> baseRoles = new ArrayList<>(); // 当前用户角色列表

        // 查询用户所属角色列表
        RoleUserRel baseRoleUserRelQuery = new RoleUserRel();
        baseRoleUserRelQuery.setUserId((Long) loginId);
        List<RoleUserRel> baseRoleUserRels = roleUserRelService.selectList(baseRoleUserRelQuery);
        if(baseRoleUserRels.size()>0){

            for (RoleUserRel baseRoleUserRel : baseRoleUserRels){
                Role baseRole = roleService.selectOne(baseRoleUserRel.getRoleId());
                baseRoles.add(baseRole);
            }
        }

        List<String> authorityList = new ArrayList<>();
        for (Role role : baseRoles) {
            authorityList.add(role.getRoleName());
        }
        return authorityList;

    }

}