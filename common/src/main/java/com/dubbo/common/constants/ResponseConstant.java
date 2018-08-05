package com.dubbo.common.constants;

/**
 * @author Stony Created Date : 2016/4/20  17:45
 */
public abstract class ResponseConstant {

    /**
     * 成功
     **/
    public static final int CODE_SUCUESS = 100000;
    public static final String MSG_SUCUESS = "";
    /**
     * 身份验证无效
     **/
    public static final int CODE_TICKET_INVALID = 100001;
    public static final String MSG_TICKET_INVALID = "验证失败";

    /**
     * 签名无效
     **/
    public static final int CODE_SIGN_INVALID = 100002;
    public static final String MSG_SIGN_INVALID = "请求签名无效";

    public static final int CODE_TAG_NOT_FOUND = 100003;
    public static final String MSG_TAG_NOT_FOUND = "标签未编辑";


    /**
     * 服务器出现错误请联系管理员
     **/
    public static final int CODE_ERROR_INVALID = 100004;
    public static final String MSG_ERROR_INVALID = "操作失败, 稍后重试";


    /**
     * 无效的参数
     **/
    public static final int CODE_PARM_INVALID = 100005;
    public static final String MSG_PARM_INVALID = "无效的参数";

    public static final int CODE_LOGIN_INVALID = 100006;
    public static final String MSG_LOGIN_INVALID = "帐号或密码错误";


    /**
     * 会话失效
     */
    public static final int CODE_SESSION_INVALID = 100009;
    public static final String MSG_SESSION_INVALID = "请重新登录";


    /**
     * 创建目录及文件失败
     */
    public static final int CODE_UPLOAD_ERROR = 100010;
    public static final String MSG_UPLOAD_ERROR = "上传文件失败";


    public static final int CODE_SAVE_ERROR = 100011;
    public static final String MSG_SAVE_ERROR = "保存信息失败";

    /**
     * 其他错误，未知错误
     */
    public static final int CODE_OTHER_INVALID = 200000;
    public static final String MSG_OTHER_INVALID = "其他错误";


    /**
     * 参数校验异常
     */
    public static final int CODE_PARAMETER_INVALID = 100013;
    public static final String MSG_PARAMETER_INVALID = "参数校验失败";


    /**
     * 更新账户错误
     */
    public static final int CODE_UPDATE_ACCOUNT_INVALID = 100016;


    //通用响应
    public static final int CODE_QUERY_FAILED = 100021;
    public static final String MSG_QUERY_FAILED = "查询失败,稍后重试";

    public static final int CODE_UPDATE_FAILED = 100022;
    public static final String MSG_UPDATE_FAILED = "保存失败, 稍后重试";
    //


    /**
     * 上传图片失败
     */
    public static final int CODE_UPDATE_FILE_FAIL = 100023;

    /**
     * 创建 用户详细错误
     **/
    public static final int CODE_CREATE_DETAIL_FAIL = 100024;

    /**
     * 更新 用户详细错误
     **/
    public static final int CODE_UPDATE_DETAIL_FAIL = 100025;


    public static final int CODE_VIDEO_NOT_FOUND = 110000;
    public static final String MSG_VIDEO_NOT_FOUNT = "未找到该文件";


    public static final int CODE_VIDEO_NOT_ANYLSIS = 110001;
    public static final String MSG_VIDEO_NOT_ANYLSIS = "文件暂未解析";

    /**
     * 用户注册相关
     **/
    public static final int CODE_REGISTER_EXIST = 100025;
    public static final String MSG_REGISTER_EXIST = "该帐号已被注册";
    /**
     * 输入验证码不正确
     **/
    public static final int CODE_REGISTER_CODE = 100026;
    public static final String MSG_REGISTER_CODE = "输入的验证码错误";

    /**
     * 用户状态；0:无效，1:有效；2：注册待审核；3：注册申请审核未通过
     **/
    public static final String USER_VALID_STATUS_ = "1";
    public static final String USER_INVALID_STATUS_ = "0";
    public static final String USER_REGISTER_PENGDING_APPROVE = "2";
    public static final String USER_REGISTER_APPROVE_NOT_PASSED = "3";

    /**
     * 注册时默认所属机构
     **/
    public static final String INITIAL_ORGANIZATION = "0";

    /**
     * 修改密码时，原始密码不正确
     **/
    public static final int CODE_UPDATE_PASSWORD_FAILED = 100027;
    public static final String MSG_UPDATE_PASSWORD_FAILED = "输入的原始密码不正确";


    /**
     * 用户不存在
     **/
    public static final int CODE_USER_NOT_EXIST = 100028;
    public static final String MSG_USER_NOT_EXIST = "用户不存在";

    /**
     * 用户新增终端时，已存在
     **/
    public static final int CODE_USER_TERMINAL_EXIST = 100029;
    public static final String MSG_USER_TERMINAL_EXIST = "该终端已存在，请重新输入！";

    /**
     * 商品不存在
     **/
    public static final int CODE_PRODUCT_NOT_EXIST = 100030;
    public static final String MSG_PRODUCT_NOT_EXIST = "该商品不存在，请重新购买其他商品！";

    /**
     * 用户已购买商品
     **/
    public static final int CODE_USER_PRODUCT_EXIST = 100031;
    public static final String MSG_USER_PRODUCT_EXIST = "您已购买商品，不允许重复购买！";

    /**
     * 暂无数据
     **/
    public static final int CODE_NOT_PARA = 100032;
    public static final String MSG_NOT_PARA = "暂无数据！";

    /**
     * 用户未购买商品
     **/
    public static final int CODE_USER_PRODUCT_NOT_EXIST = 100033;
    public static final String MSG_USER_PRODUCT_NOT_EXIST = "您还未购买任何产品！";

    /**
     * 该视频无法编辑元素标签
     **/
    public static final int CODE_NOT_CREATE_ELEMENT_TAGS = 100034;
    public static final String MSG_NOT_CREATE_ELEMENT_TAGS = "该视频播放时间不满足元素标签限制！";

    /**
     * 该视频已存在元素标签
     **/
    public static final int CODE_EXIST_ELEMENT_TAGS = 100035;
    public static final String MSG_EXIST_ELEMENT_TAGS = "该视频播已存在元素标签，不能重复添加！";

    /**
     * 您注册的账号已存在，等待管理员审核。
     **/
    public static final int CODE_REGISTER_PENGDING_APPROVE = 100036;
    public static final String MSG_REGISTER_PENGDING_APPROVE = "您注册的账号已存在，等待管理员审核。";

    /**
     * 您注册的账号，未通过审核。
     **/
    public static final int CODE_REGISTER_APPROVE_NOT_PASSED = 100037;
    public static final String MSG_REGISTER_APPROVE_NOT_PASSED = "您注册的账号，未通过审核。";

    /**
     * 您注册的账号还未被审核通过，暂时无法登陆。
     **/
    public static final int CODE_LOGIN_PENGDING_APPROVE = 100038;
    public static final String MSG_LOGIN_PENGDING_APPROVE = "您注册的账号还未被审核通过，暂时无法登陆。";

    /**
     * 您注册的账号未被审核通过，暂时无法登陆。
     **/
    public static final int CODE_LOGIN_APPROVE_NOT_PASSED = 100039;
    public static final String MSG_LOGIN_APPROVE_NOT_PASSED = "您注册的账号未被审核通过，暂时无法登陆。";

    /**
     * 您的账号存在异常，无法登陆，请联系管理员。
     **/
    public static final int CODE_LOGIN_ERROR = 100040;
    public static final String MSG_LOGIN_ERROR = "您的账号存在异常，无法登陆，请联系管理员。";

    /**
     * 恭喜您注册成功，等待管理员审核。。
     **/
    public static final int CODE_REGISTER_SUCCESS = 100041;
    public static final String MSG_REGISTER_SUCCESS = "恭喜您注册成功，等待管理员审核。";
}
