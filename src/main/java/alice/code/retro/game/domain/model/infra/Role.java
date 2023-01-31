package alice.code.retro.game.domain.model.infra;

import com.fasterxml.jackson.annotation.JsonFormat;
import alice.code.retro.game.common.domain.Transient;
import alice.code.retro.game.common.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 角色基本信息表Domain
 * User: contact@liuxp.me
 * Date: 2023-01-28
 **/
@Getter
@Setter
public class Role extends AbstractEntity{

    /**
     * 角色名称
     */
    private String roleName;
    /**
     * 角色描述
     */
    private String roleDescription;
    /**
     * 状态 0:正常 1:禁用
     */
    private Integer isEnable;

}