package alice.code.retro.game.controller.infra;

import alice.code.retro.game.common.domain.Page;
import alice.code.retro.game.common.domain.PageParam;
import alice.code.retro.game.common.domain.Result;
import alice.code.retro.game.common.framework.MultiRequestBody;
import alice.code.retro.game.common.util.ParamUtil;
import alice.code.retro.game.domain.model.infra.Menu;
import alice.code.retro.game.service.infra.MenuService;
import cn.dev33.satoken.stp.StpUtil;
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

    // 测试登录，浏览器访问： http://localhost:9091/web/infra/auth/login?username=zhang&password=123456
    @RequestMapping("login")
    @ResponseBody
    public String doLogin(String username, String password) {
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("zhang".equals(username) && "123456".equals(password)) {
            StpUtil.login(10001);
            return "登录成功";
        }
        return "登录失败";
    }

    // 查询登录状态，浏览器访问： http://localhost:9091/web/infra/auth/isLogin
    @RequestMapping("isLogin")
    @ResponseBody
    public String isLogin() {
        return "当前会话是否登录：" + StpUtil.isLogin();
    }

}