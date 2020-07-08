package frank.model;



/**
 * @author 张益月
 * @version 1.0
 * @date 2020/3/8 9:43
 */
public class Result {

    //是否请求成功
    private boolean success;
    //消息码
    private String code;
    //错误消息
    private String message;
    //返回数据
    private Object data;

    @Override
    public String toString() {
        return "Result{" +
                "success=" + success +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
