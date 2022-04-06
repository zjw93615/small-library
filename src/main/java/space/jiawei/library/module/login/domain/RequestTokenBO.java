package space.jiawei.library.module.login.domain;

import lombok.Getter;
import space.jiawei.library.module.user.domain.bo.UserBO;

@Getter
public class RequestTokenBO {

    private Long requestUserId;

    private UserBO userBO;

    public RequestTokenBO(UserBO userBO) {
        this.requestUserId = userBO.getId();
        this.userBO = userBO;
    }

    @Override
    public String toString() {
        return "RequestTokenBO{" +
                "requestUserId=" + requestUserId +
                ", employeeBO=" + userBO +
                '}';
    }
}
