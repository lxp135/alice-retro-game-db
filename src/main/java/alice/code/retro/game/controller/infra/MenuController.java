package alice.code.retro.game.controller.infra;

import alice.code.retro.game.common.domain.Page;
import alice.code.retro.game.common.domain.PageParam;
import alice.code.retro.game.common.domain.Result;
import alice.code.retro.game.common.framework.MultiRequestBody;
import alice.code.retro.game.common.util.ParamUtil;
import alice.code.retro.game.domain.model.infra.Menu;
import alice.code.retro.game.service.infra.MenuService;
import cn.dev33.satoken.annotation.SaCheckPermission;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 菜单基本信息表Controller
 * User: contact@liuxp.me
 * DateTime: 2023-01-28
 */
@Controller
@RequestMapping("/web/infra/menu")
@SaCheckPermission("INFRA_MENU")
public class MenuController{

    /**
     * 菜单基本信息表Service接口
     */
    @Resource
    private MenuService menuService;

    /**
     * 根据条件分页查询
     * @param menu 菜单基本信息表数据实体
     * @param pageParam 分页入参
     * @return Page<Menu> 分页列表
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseBody
    public Result<Page<Menu>> page(@MultiRequestBody Menu menu,@MultiRequestBody PageParam pageParam) {

        Page<Menu> page = ParamUtil.buildPage(menu, pageParam);
        // 执行查询
        Page<Menu> result = menuService.selectPage(page);

        return new Result<>(result);
    }

    /**
     * 根据条件查询
     * @param menu 菜单基本信息表数据实体
     * @return 菜单基本信息表列表
    */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Result<List<Menu>> list(@RequestBody Menu menu) {

        List<Menu> result = menuService.selectList(menu);

        return new Result<>(result);
    }

    /**
     * 根据主键查询
     * @param id 主键
     * @return 菜单基本信息表
    */
    @RequestMapping(value = "/one", method = RequestMethod.POST)
    @ResponseBody
    public Result<Menu> one(@RequestParam Long id) {

        Menu result = menuService.selectOne(id);

        return new Result<>(result);
    }

    /**
     * 保存数据
     * @param menu 菜单基本信息表数据实体
     * @return 执行结果
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result<Menu> insert(@RequestBody Menu menu) {

        // 执行插入，返回已设置主键的数据实体
        Menu result = menuService.insert(menu);

        return new Result<>(result);
    }

    /**
     * 修改数据
     * @param menu 菜单基本信息表数据实体
     * @return 执行结果
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> update(@RequestBody Menu menu) {
        // 执行更新
        int rows = menuService.update(menu);

        return new Result<>(rows > 0);
    }

    /**
     * 逻辑删除数据
     * @param id 主键
     * @return 执行结果
     */
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> delete(@RequestParam Long id) {
        // 执行逻辑删除
        int rows = menuService.delete(id);

        return new Result<>(rows > 0);
    }

}