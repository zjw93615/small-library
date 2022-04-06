package space.jiawei.library.module.user.domain.bo;

import lombok.Getter;
import space.jiawei.library.module.user.domain.entity.UserEntity;

@Getter
public class UserBO {
    /**
     * 主键id
     */
    private Long id;

    /**
     * 登录账号
     */
    private String loginName;

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
     * 是否被禁用
     */
    private Integer isDisabled;

    /**
     * 删除状态 0否 1是
     */
    private Integer isDelete;

    /**
     * 是否为超级管理员
     */
    private Integer isAdmin;

    public UserBO(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.loginName = userEntity.getLoginName();
        this.actualName = userEntity.getActualName();
        this.nickName = userEntity.getNickName();
        this.phone = userEntity.getPhone();
        this.isDisabled = userEntity.getIsDisabled();
        this.isDelete = userEntity.getIsDelete();
        this.isAdmin = userEntity.getIsAdmin();
    }
}
