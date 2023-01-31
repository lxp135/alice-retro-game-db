package alice.code.retro.game.domain.model.infra;

import com.fasterxml.jackson.annotation.JsonFormat;
import alice.code.retro.game.common.domain.Transient;
import alice.code.retro.game.common.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 邀请码表Domain
 * User: contact@liuxp.me
 * Date: 2023-01-28
 **/
@Getter
@Setter
public class UserInvitation extends AbstractEntity{

    /**
     * 用户编号
     */
    private Long userId;
    /**
     * 用户账号
     */
    private String userAccount;
    /**
     * 邀请码
     */
    private String invitationCode;
    /**
     * 被邀请用户编号
     */
    private Long invitedUserId;
    /**
     * 被邀请用户账号
     */
    private String invitedUserAccount;
    /**
     * 是否已使用 0:未使用 1:已使用
     */
    private Integer isUsed;
    /**
     * 使用时间
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date usedTime;
    /**
     * 使用时间/起(虚拟字段：用于时间段查询)
     */
    @Transient
    private String usedTimeBegin;
    /**
     * 使用时间/止(虚拟字段：用于时间段查询)
     */
    @Transient
    private String usedTimeEnd;

}