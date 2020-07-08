package frank.exceeption;

/**
 * @author 张益月
 * @version 1.0
 * @date 2020/3/10 16:06
 */
public class BaseException extends RuntimeException{

    private String code;

    private String message;

    public BaseException(String code,String message) {
        super(message);
        this.code=code;
    }

    public BaseException(String code,String message, Throwable cause) {
        super(message, cause);
        this.message=message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
