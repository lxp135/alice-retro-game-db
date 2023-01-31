package alice.code.retro.game.domain.model;

import alice.code.retro.game.domain.model.infra.Menu;
import alice.code.retro.game.domain.model.infra.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
* 登录用户
* @author contact@liuxp.me
*/
@Setter
@Getter
public class Account{

	private static final long serialVersionUID = 1L;

	private Long id;
	// 用户账号
	private String userAccount;
	// 用户名称
	private String userName;
	// 性别 0:未填写 1:男 2:女
	private Integer userSex;
	// 用户头像
	private String userFace;
	// 电子邮件
	private String userEmail;
	// 微信号
	private String userWechat;
	// 手机号
	private String userPhone;

	private List<Role> roles;

	private List<Menu> menus;

}