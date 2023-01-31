package alice.code.retro.game.service.infra;

import alice.code.retro.game.common.service.IService;
import alice.code.retro.game.domain.model.Account;

/**
 * 用户鉴权
 * User: contact@liuxp.me
 * DateTime: 2023-01-31
 **/
public interface AuthService {

    /**
     * 登录
     * @param account 账号
     * @param password 密码
     * @return Account 账号信息
     */
    Account login(String account, String password);
}