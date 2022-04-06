package space.jiawei.library.module.user.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import space.jiawei.library.util.SmartVerificationUtil;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@Data
public class UserAddDTO {
    @ApiModelProperty("姓名")
    @NotNull(message = "姓名不能为空")
    private String actualName;

    @ApiModelProperty("登录名")
    @NotNull(message = "姓名不能为空")
    private String loginName;

    @ApiModelProperty("别名")
    private String nickName;

    @ApiModelProperty("是否启用")
    @NotNull(message = "是否被禁用不能为空")
    private Integer isDisabled;

    @ApiModelProperty("手机号")
    @NotNull(message = "手机号不能为空")
    @Pattern(regexp = SmartVerificationUtil.PHONE_REGEXP, message = "手机号格式不正确")
    private String phone;

    @ApiModelProperty("身份证(可选)")
    private String idCard;

    @ApiModelProperty("生日(可选)")
    private String birthday;

    @ApiModelProperty("密码")
    //    @NotNull(message = "密码不能为空")
    //    @Length(min = 6, message = "密码最少为6位字符")
    private String loginPwd;

    @ApiModelProperty("邮箱")
    private String email;

}
