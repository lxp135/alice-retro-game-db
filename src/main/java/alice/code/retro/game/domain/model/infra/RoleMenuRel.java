package alice.code.retro.game.domain.model.infra;

import com.fasterxml.jackson.annotation.JsonFormat;
import alice.code.retro.game.common.domain.Transient;
import alice.code.retro.game.common.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 角色与菜单关系表Domain
 * User: contact@liuxp.me
 * Date: 2023-01-28
 **/
@Getter
@Setter
public class RoleMenuRel extends AbstractEntity{

    /**
     * 角色表主键
     */
    private Long roleId;
    /**
     * 菜单表主键
     */
    private Long menuId;

}