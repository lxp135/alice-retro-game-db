package alice.code.retro.game.common.enums;

/**
 * 异常信息枚举类
 *
 * @author contact@liuxp.me
 */
public enum ErrorCodeEnum {

    E0000("E0000", "未定义异常"),
    E1000("E1000", "参数异常"),
    E2000("E2000", "运行时异常"),
    E3000("E3000", "数据库异常"),
    E3001("E3001", "数据库异常 - 完整性校验失败"),
    E4000("E4000", "文件解析异常"),
    E9000("E9000", "业务异常");

    /**
     * 构造方法
     *
     * @param code 编码
     * @param msg  名称
     */
    ErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    private final String code;

    private final String msg;

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}