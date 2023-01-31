package alice.code.retro.game.service.infra.impl;

import alice.code.retro.game.common.service.AbstractService;
import alice.code.retro.game.dao.infra.UserInvitationDao;
import alice.code.retro.game.service.infra.UserInvitationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 邀请码表Service层实现类
 * User: contact@liuxp.me
 * DateTime: 2023-01-28
 **/
@Service
public class UserInvitationServiceImpl extends AbstractService implements UserInvitationService {

    @Autowired
    public void setDao(UserInvitationDao dao) {this.iDao = dao;}

}