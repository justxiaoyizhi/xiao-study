package com.xyz.company.xiao20170210;

/**
 * 错误代码的枚举
 *
 * @author xiao
 * @create 2017-02-10 14:39
 **/
public enum ErrorCode {
    /**
     * 成功上线
     */
    ONLINE_SUCCESS("90005"),
    /**
     * 待上线(审核成功后状态为待上线)
     */
    ONLINE_WAIT("90006"),
    /**
     * 待审核
     */
    APPROVAL_WAIT("90007"),
    /**
     * 审核失败
     */
    APPROVAL_FAIL("90008"),
    /**
     * 等待下线
     */
    OFFLINE_WAIT("90009"),
    /**
     * 已下线
     */
    OFFLINE_SUCCESS("90010");
    private String code;

    public String getCode() {
        return code;
    }

    ErrorCode(String code) {
        this.code = code;
    }
}
