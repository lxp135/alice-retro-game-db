package alice.code.retro.game.domain.model.infra;

import alice.code.retro.game.common.domain.AbstractEntity;
import alice.code.retro.game.common.domain.Transient;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单基本信息表Domain
 * User: contact@liuxp.me
 * Date: 2023-01-28
 **/
@Getter
@Setter
public class Menu extends AbstractEntity{

    /**
     * 菜单英文名称
     */
    private String menuKey;
    /**
     * 菜单中文名称
     */
    private String menuName;
    /**
     * 菜单描述
     */
    private String menuDescription;
    /**
     * 菜单地址
     */
    private String menuUrl;
    /**
     * 菜单图标
     */
    private String menuIcon;
    /**
     * 菜单类型
     */
    private Integer menuType;
    /**
     * 菜单级别
     */
    private Integer menuLevel;
    /**
     * 菜单顺序
     */
    private Integer menuOrder;
    /**
     * 父级主键
     */
    private Long menuParentId;
    /**
     * 父级菜单名称
     */
    private String menuParentName;
    /**
     * 是否选中
     */
    @Transient
    private Boolean isCheck;
    /**
     * 子菜单
     */
    @Transient
    private List<Menu> childMenus = new ArrayList<>();

    public void addChildMenu(Menu baseMenu){
        this.childMenus.add(baseMenu);
    }
}