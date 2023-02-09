package alice.code.retro.game.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 解决React 应用与 spring boot 相结合的问题。
 * 之前我们部署使用 nginx部署，部署复杂度略高一些，通过这样处理，可以一个jar包搞定了。
 * 思路： 当访问的请求不存在，都跳转到react的index.html页面
 * 虽然不够优雅，但是解决了spring boot 与 react 应用结合的问题
 * 也许性能上略有损耗，应该是可以忽略不计的。
 */
@Controller
public class ReactController implements ErrorController {

    @RequestMapping(value = "/error")
    public String getIndex(){
        return "index"; //返回index页面
    }

}