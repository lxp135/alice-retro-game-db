package alice.code.retro.game.controller.infra;

import alice.code.retro.game.common.domain.Page;
import alice.code.retro.game.common.domain.PageParam;
import alice.code.retro.game.common.domain.Result;
import alice.code.retro.game.common.framework.MultiRequestBody;
import alice.code.retro.game.common.util.ParamUtil;
import alice.code.retro.game.domain.model.infra.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import alice.code.retro.game.service.infra.UserService;
import cn.dev33.satoken.annotation.SaCheckPermission;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户信息表Controller
 * User: contact@liuxp.me
 * DateTime: 2023-02-01
 */
@Controller
@RequestMapping("/web/infra/user")
@SaCheckPermission("INFRA_USER")
public class UserController{

    /**
     * 用户信息表Service接口
     */
    @Resource
    private UserService userService;

    /**
     * 根据条件分页查询
     * @param user 用户信息表数据实体
     * @param pageParam 分页入参
     * @return Page<User> 分页列表
     */
    @RequestMapping(value = "/page", method = RequestMethod.POST)
    @ResponseBody
    public Result<Page<User>> page(@MultiRequestBody User user,@MultiRequestBody PageParam pageParam) {

        Page<User> page = ParamUtil.buildPage(user,pageParam);
        // 执行查询
        Page<User> result = userService.selectPage(page);
        // 返回结果
        return new Result<>(result);
    }

    /**
     * 根据条件查询
     * @param user 用户信息表数据实体
     * @return 用户信息表列表
    */
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    @ResponseBody
    public Result<List<User>> list(@RequestBody User user) {
      
        // 执行查询
        List<User> result = userService.selectList(user);
        // 返回结果
        return new Result<>(result);
    }

    /**
     * 根据主键查询
     * @param id 主键
     * @return 用户信息表
    */
    @RequestMapping(value = "/one", method = RequestMethod.POST)
    @ResponseBody
    public Result<User> one(@RequestParam Long id) {
      
        // 执行查询
        User result = userService.selectOne(id);
        // 返回结果
        return new Result<>(result);
    }

    /**
     * 保存数据
     * @param user 用户信息表数据实体
     * @return 执行结果
     */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public Result<User> insert(@RequestBody User user) {

        // 执行插入，返回已设置主键的数据实体
        User result = userService.insert(user);
        // 返回结果
        return new Result<>(result);
    }

    /**
     * 修改数据
     * @param user 用户信息表数据实体
     * @return 执行结果
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Result<Boolean> update(@RequestBody User user) {
        // 执行更新
        int rows = userService.update(user);
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
        int rows = userService.delete(id);
        // 返回结果
        return new Result<>(rows > 0);
    }

}