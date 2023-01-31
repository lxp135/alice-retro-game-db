package alice.code.retro.game.common.framework;

import alice.code.retro.game.common.domain.Result;
import alice.code.retro.game.common.enums.ErrorCodeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;

/**
 * Controller通用异常处理
 * SpringMVC自身提供的全局异常处理类，仅捕获Controller级别抛出异常
 * 被捕获异常按照顺序匹配处理方法（仅匹配最前面的一个方法）
 * @author contact@liuxp.me
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 业务异常
     * @param e 被捕获的异常
     * @return 异常信息
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public Result<Boolean> businessExceptionHandle(BusinessException e){
        return printErrorLogs(ErrorCodeEnum.E9000, e);
    }

    /**
     * 参数异常
     * @param e 被捕获的异常
     * @return 异常信息
     */
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public Result<Boolean> handleIllegalArgumentException(IllegalArgumentException e){
        return printErrorLogs(ErrorCodeEnum.E1000, e);
    }

    /**
     * 数据库异常
     * @param e 被捕获的异常
     * @return 异常信息
     */
    @ExceptionHandler(SQLException.class)
    @ResponseBody
    public Result<Boolean> handleSQLException(SQLException e){
        return printErrorLogs(ErrorCodeEnum.E3000, e);
    }

    /**
     * 运行时异常
     * @param e 被捕获的异常
     * @return 异常信息
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Result<Boolean> handleRuntimeException(RuntimeException e){
        return printErrorLogs(ErrorCodeEnum.E2000, e);
    }

    /**
     * 其他异常
     * @param e 被捕获的异常
     * @return 异常信息
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Boolean> handleException(Exception e){
        return printErrorLogs(ErrorCodeEnum.E0000, e);
    }

    private Result<Boolean> printErrorLogs(ErrorCodeEnum errorCodeEnum,Exception e){
        e.printStackTrace();
        return new Result<>(errorCodeEnum.getCode(),errorCodeEnum.getMsg()+"："+e.getMessage());
    }
}
