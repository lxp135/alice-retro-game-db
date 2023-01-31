package alice.code.retro.game.common.domain;

import java.io.Serializable;

/**
 * 接口返回值包装类
 * @author contact@liuxp.me
 */
public class Result<T> implements Serializable {

    // 序列化
    private static final long serialVersionUID = 1L;
    // 是否成功
    private final boolean success;
    // 返回结果
    private final T data;
    // 错误码
    private final String errorCode;
    // 提示消息
    private final String errorMessage;

    /**
     * 无参构造器
     */
    private Result() {
        this.success = true;
        this.data = null;
        this.errorCode = null;
        this.errorMessage = null;
    }

    /**
     * 成功返回构造
     *
     * @param data 返回结果
     */
    public Result(T data) {
        this.success = true;
        this.data = data;
        this.errorCode = null;
        this.errorMessage = null;
    }

    /**
     * 空返回构造
     *
     * @param errorCode    错误码
     * @param errorMessage 提示信息
     */
    public Result(String errorCode, String errorMessage) {
        this.success = false;
        this.data = null;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    /**
     * 是否执行成功
     *
     * @return 是否成功
     */
    public boolean isSuccess() {
        return success;
    }

    /**
     * 取得执行结果
     *
     * @return 执行结果
     */
    public T getData() {
        return data;
    }

    /**
     * 取得错误码
     *
     * @return 错误码
     */
    public String getErrorCode() {
        return errorCode;
    }

    /**
     * 取得提示信息
     *
     * @return 提示信息
     */
    public String getErrorMessage() {
        return errorMessage;
    }

}
