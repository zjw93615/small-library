package space.jiawei.library.module.user.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class UserQueryExportDTO {

    @ApiModelProperty(hidden = true)
    private String phone;

    @ApiModelProperty("姓名")
    private String actualName;

    @ApiModelProperty(hidden = true)
    private String keyword;

    @ApiModelProperty(hidden = true)
    private Integer isLeave;

    @ApiModelProperty(hidden = true)
    private Integer isDisabled;

    /**
     * 删除状态 0否 1是
     */
    @ApiModelProperty(value = "删除状态 0否 1是 不需要传", hidden = true)
    private Integer isDelete;

    @ApiModelProperty(value = "用户ID集合", hidden = true)
    private List<Long> userIds;

}
