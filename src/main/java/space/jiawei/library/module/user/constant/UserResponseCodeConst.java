package space.jiawei.library.module.user.constant;

import space.jiawei.library.common.constant.ResponseCodeConst;

public class UserResponseCodeConst extends ResponseCodeConst {

    /**
     * 员工不存在
     */
    public static final UserResponseCodeConst EMP_NOT_EXISTS = new UserResponseCodeConst(3001, "员工不存在！");

    /**
     * 更新员工信息失败
     */
    public static final UserResponseCodeConst UPDATE_FAILED = new UserResponseCodeConst(3002, "员工更新失败！");

    /**
     * 部门信息不存在
     */
    public static final UserResponseCodeConst DEPT_NOT_EXIST = new UserResponseCodeConst(3003, "部门信息不存在!");

    /**
     * 用户名或密码错误
     */
    public static final UserResponseCodeConst LOGIN_FAILED = new UserResponseCodeConst(3004, "用户名或密码错误!");

    /**
     * 您的账号已被禁用，不得登录系统
     */
    public static final UserResponseCodeConst IS_DISABLED = new UserResponseCodeConst(3005, "您的账号已被禁用，不得登录系统!");

    /**
     * 登录名已存在
     */
    public static final UserResponseCodeConst LOGIN_NAME_EXISTS = new UserResponseCodeConst(3006, "登录名已存在!");
    /**
     * 密码输入有误，请重新输入 10115
     */
    public static final UserResponseCodeConst PASSWORD_ERROR = new UserResponseCodeConst(3007, "密码输入有误，请重新输入");
    /**
     * 手机号已存在
     */
    public static final UserResponseCodeConst PHONE_EXISTS = new UserResponseCodeConst(3008, "手机号已经存在");

    public static final UserResponseCodeConst ID_CARD_ERROR = new UserResponseCodeConst(3009, "请输入正确的身份证号");

    public static final UserResponseCodeConst BIRTHDAY_ERROR = new UserResponseCodeConst(3010, "生日格式不正确");

    public static final UserResponseCodeConst VERIFICATION_CODE_INVALID = new UserResponseCodeConst(3011, "验证码无效");

    public UserResponseCodeConst(int code, String msg) {
        super(code, msg);
    }
}

