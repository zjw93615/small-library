package space.jiawei.library.module.user;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import space.jiawei.library.common.anno.OperateLog;
import space.jiawei.library.common.domain.PageResultDTO;
import space.jiawei.library.common.domain.ResponseDTO;
import space.jiawei.library.module.user.domain.dto.UserAddDTO;
import space.jiawei.library.module.user.domain.dto.UserQueryDTO;
import space.jiawei.library.module.user.domain.vo.UserVO;

import javax.validation.Valid;

@RestController
@OperateLog
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/user/query")
    @ApiOperation(value = "用户管理查询", notes = "员工管理查询 @author lidoudou")
    public ResponseDTO<PageResultDTO<UserVO>> query(@RequestBody UserQueryDTO query) {
        return userService.selectUserList(query);
    }

    @ApiOperation(value = "添加用户", notes = "@author yandanyang")
    @PostMapping("/user/add")
    public ResponseDTO<String> addEmployee(@Valid @RequestBody UserAddDTO user) {
//        RequestTokenBO requestToken = SmartRequestTokenUtil.getRequestUser();
        return userService.addUser(user);
    }
}
