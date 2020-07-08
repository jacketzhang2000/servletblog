package frank.exceeption;

/**
 * @author 张益月
 * @version 1.0
 * @date 2020/3/10 15:47
 */
public class BusinessException extends BaseException{

    public BusinessException(String code, String message) {
        super(code, message);
    }

    public BusinessException(String code, String message, Throwable cause) {
        super(code, message, cause);
    }
}
