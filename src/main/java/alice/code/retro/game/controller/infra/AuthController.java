package alice.code.retro.game.controller.infra;

import alice.code.retro.game.common.domain.Page;
import alice.code.retro.game.common.domain.PageParam;
import alice.code.retro.game.common.domain.Result;
import alice.code.retro.game.common.framework.MultiRequestBody;
import alice.code.retro.game.common.util.ParamUtil;
import alice.code.retro.game.domain.model.Account;
import alice.code.retro.game.domain.model.infra.Menu;
import alice.code.retro.game.service.infra.AuthService;
import alice.code.retro.game.service.infra.MenuService;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.lang.Assert;
import cn.hutool.crypto.SecureUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 鉴权Controller
 * User: contact@liuxp.me
 * DateTime: 2023-01-31
 */
@Controller
@RequestMapping("/web/infra/auth")
public class AuthController {

    @Resource
    AuthService authService;

    // 测试登录，浏览器访问： http://localhost:9091/web/infra/auth/login?account=zhang&password=123456
    @RequestMapping("login")
    @ResponseBody
    public Result<Account> login(String account, String password) {

        Assert.notBlank(account, "account账号不能为空");
        Assert.notBlank(password, "password密码不能为空");

        Account result = authService.login(account, password);

        return new Result<>(result);

    }

    // 查询登录状态，浏览器访问： http://localhost:9091/web/infra/auth/isLogin
    @RequestMapping("isLogin")
    @ResponseBody
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

}