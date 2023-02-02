package alice.code.retro.game.controller.infra;

import alice.code.retro.game.common.domain.Page;
import alice.code.retro.game.common.domain.PageParam;
import alice.code.retro.game.common.domain.Result;
import alice.code.retro.game.common.framework.MultiRequestBody;
import alice.code.retro.game.common.util.ParamUtil;
import alice.code.retro.game.domain.model.infra.Role;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import alice.code.retro.game.service.infra.RoleService;
import cn.dev33.satoken.annotation.SaCheckPermission;

import javax.annotation.Resource;
import java.util.List;

/**
 * 角色基本信息表Controller
 * User: contact@liuxp.me
 * DateTime: 2023-02-01
 */
@Controller
@RequestMapping("/web/infra/role")
@SaCheckPermission("INFRA_ROLE")
public class RoleController{

    /**
     * 角色基本信息表Service接口
     */
    @Resource
    private RoleService roleService;

    /**
     * 根据条件分页查询
     * @param role 角色基本信息表数据实体
     * @param pageParam 分页入参
     * @return Page<Role> 分页列表
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseBody
    public Result<Page<Role>> page(@MultiRequestBody Role role,@MultiRequestBody PageParam pageParam) {

        Page<Role> page = ParamUtil.buildPage(role,pageParam);
        // 执行查询
        Page<Role> result = roleService.selectPage(page);
        // 返回结果
        return new Result<>(result);
    }

    /**
     * 根据条件查询
     * @param role 角色基本信息表数据实体
     * @return 角色基本信息表列表
    */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Result<List<Role>> list(@RequestBody Role role) {
      
        // 执行查询
        List<Role> result = roleService.selectList(role);
        // 返回结果
        return new Result<>(result);
    }

    /**
     * 根据主键查询
     * @param id 主键
     * @return 角色基本信息表
    */
    @RequestMapping(value = "/one", method = RequestMethod.POST)
    @ResponseBody
    public Result<Role> one(@RequestParam Long id) {
      
        // 执行查询
        Role result = roleService.selectOne(id);
        // 返回结果
        return new Result<>(result);
    }

    /**
     * 保存数据
     * @param role 角色基本信息表数据实体
     * @return 执行结果
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result<Role> insert(@RequestBody Role role) {

        // 执行插入，返回已设置主键的数据实体
        Role result = roleService.insert(role);
        // 返回结果
        return new Result<>(result);
    }

    /**
     * 修改数据
     * @param role 角色基本信息表数据实体
     * @return 执行结果
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> update(@RequestBody Role role) {
        // 执行更新
        int rows = roleService.update(role);
        // 返回结果
        return new Result<>(rows > 0);
    }

    /**
     * 删除数据
     * @param id 主键
     * @return 执行结果
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam Long id) {
        // 执行逻辑删除
        int rows = roleService.delete(id);
        // 返回结果
        return new Result<>(rows > 0);
    }

}