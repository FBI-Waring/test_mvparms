package com.example.app.common.model.bean.response;


/**
 * <pre>
 * Description:
 * @author :   ys
 * @date :         2020/5/7
 * </pre>
 */
public class MainRsp {

    /**
     * data : {"cnickname":"","userId":"10009494","token":"eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIxMDAwOTQ5NCIsInBhc3N3b3JkIjoiZjRhYmE1NTVlNDRhYjdiMTEzOTBiNWYzNTQ4MjExNjUiLCJtb2JpbGVObyI6IjE4MTI0MTA0ODkxIiwiZXhwIjoxNTg5NDU1OTMwLCJ1c2VySWQiOiIxMDAwOTQ5NCIsImlhdCI6MTU4OTE5NjczMCwianRpIjoiMTAzMzA5NDctNjg0ZS00M2VkLWI3MWItNTAzNDg0ZGJiMWE1In0.rNMYkYp4wupRwLpMwWd9FM7wuZqbfcYh8PhtuetT6Qw"}
     * message : 成功
     * status : _0000
     */

    private String status;
    private String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
