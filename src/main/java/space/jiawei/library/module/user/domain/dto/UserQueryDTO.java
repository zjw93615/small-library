package space.jiawei.library.module.user.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import space.jiawei.library.common.domain.PageParamDTO;

import java.util.List;

@Data
public class UserQueryDTO extends PageParamDTO {
    private String phone;

    private String actualName;

    private String keyword;

    private Integer isLeave;

    private Integer isDisabled;

    /**
     * 删除状态 0否 1是
     */
    @ApiModelProperty("删除状态 0否 1是 不需要传")
    private Integer isDelete;

    @ApiModelProperty("用户id集合")
    private List<Long> userIds;
}
