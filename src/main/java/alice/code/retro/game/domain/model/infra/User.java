package alice.code.retro.game.domain.model.infra;

import com.fasterxml.jackson.annotation.JsonFormat;
import alice.code.retro.game.common.domain.Transient;
import alice.code.retro.game.common.domain.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户信息表Domain
 * User: contact@liuxp.me
 * Date: 2023-01-28
 **/
@Getter
@Setter
public class User extends AbstractEntity{

    /**
     * 用户账号
     */
    private String userAccount;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPassword;
    /**
     * 性别 0:未填写 1:男 2:女
     */
    private Integer userSex;
    /**
     * 用户头像
     */
    private String userFace;
    /**
     * 电子邮件
     */
    private String userEmail;
    /**
     * 微信号
     */
    private String userWechat;
    /**
     * 手机号
     */
    private String userPhone;
    /**
     * 出生日期
     */
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date userBirthday;
    /**
     * 出生日期/起(虚拟字段：用于时间段查询)
     */
    @Transient
    private String userBirthdayBegin;
    /**
     * 出生日期/止(虚拟字段：用于时间段查询)
     */
    @Transient
    private String userBirthdayEnd;
    /**
     * 签名
     */
    private String userSignature;
    /**
     * 用户状态 0:禁用 1:正常
     */
    private Integer isEnable;
    /**
     * 是否管理员 0:否 1:是
     */
    private Integer isAdmin;

}