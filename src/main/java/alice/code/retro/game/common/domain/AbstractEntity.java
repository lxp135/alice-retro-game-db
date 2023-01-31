package alice.code.retro.game.common.domain;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.Date;

/**
 * 数据实体基类
 * @author contact@liuxp.me
 */
@Getter
@Setter
public abstract class AbstractEntity implements Serializable {

    // 序列化
    private static final long serialVersionUID = 1L;

    // 主键
    private Long id;

    // 主键最大值（用于查询）
    @Transient
    private Long idMax;

    // 主键最小值（用于查询）
    @Transient
    private Long idMin;

    // 创建时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    // 创建时间/起(虚拟字段：用于时间段查询)
    @Transient
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTimeBegin;

    // 创建时间/止(虚拟字段：用于时间段查询)
    @Transient
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTimeEnd;

    // 修改时间
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    // 修改时间/起(虚拟字段：用于时间段查询)
    @Transient
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTimeBegin;

    // 修改时间/止(虚拟字段：用于时间段查询)
    @Transient
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTimeEnd;

    /**
     * 判断属性是否有@Transient注解
     *
     * @param clazz 类
     * @param propertyName 属性名
     * @return 是否有@Transient注解
     */
    private boolean isTransient(Class<?> clazz, String propertyName) {
        // 取得基类Field
        Field[] fidldsOfSuperClazz = AbstractEntity.class.getDeclaredFields();
        // 取得子类Field
        Field[] fidldsOfClazz = clazz.getDeclaredFields();
        // 首先在基类中判断属性是否有@Transient注解
        for (Field field : fidldsOfSuperClazz) {
            if (field.getName().equals(propertyName) && field.isAnnotationPresent(Transient.class)) {
                return true;
            }
        }
        // 其次在子类中判断属性是否有@Transient注解
        for (Field field : fidldsOfClazz) {
            if (field.getName().equals(propertyName) && field.isAnnotationPresent(Transient.class)) {
                return true;
            }
        }
        return false;
    }

}
