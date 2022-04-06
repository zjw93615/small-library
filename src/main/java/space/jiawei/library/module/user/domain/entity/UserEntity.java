package space.jiawei.library.module.user.domain.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import space.jiawei.library.common.domain.BaseEntity;

import java.io.Serializable;

@Data
@TableName("li_user")
public class UserEntity extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -8794328598524272806L;

    /**
     * 登录账号
     */
    private String loginName;

    /**
     * 登录密码
     */
    private String loginPwd;

    /**
     * 用户名称
     */
    private String actualName;

    /**
     * 别名
     */
    private String nickName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 身份证
     */
    private String idCard;

    /**
     * 出生日期
     */
    private String birthday;

    /**
     * 是否被禁用
     */
    private Integer isDisabled;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否管理员 0否 1是
     */
    private Integer isAdmin;

    /**
     * 删除状态 0否 1是
     */
    private Integer isDelete;
}
