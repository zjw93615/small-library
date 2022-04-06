package space.jiawei.library.module.user;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import space.jiawei.library.common.constant.JudgeEnum;
import space.jiawei.library.common.domain.PageResultDTO;
import space.jiawei.library.common.domain.ResponseDTO;
import space.jiawei.library.constant.CommonConst;
import space.jiawei.library.module.user.constant.UserResponseCodeConst;
import space.jiawei.library.module.user.constant.UserStatusEnum;
import space.jiawei.library.module.user.domain.dto.UserAddDTO;
import space.jiawei.library.module.user.domain.dto.UserDTO;
import space.jiawei.library.module.user.domain.dto.UserQueryDTO;
import space.jiawei.library.module.user.domain.entity.UserEntity;
import space.jiawei.library.module.user.domain.vo.UserVO;
import space.jiawei.library.util.SmartBeanUtil;
import space.jiawei.library.util.SmartDigestUtil;
import space.jiawei.library.util.SmartPageUtil;
import space.jiawei.library.util.SmartVerificationUtil;

import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserService {
    private static final String RESET_PASSWORD = "123456";

    @Autowired
    private UserDao userDao;

    public ResponseDTO<PageResultDTO<UserVO>> selectUserList(UserQueryDTO queryDTO) {
        Page pageParam = SmartPageUtil.convert2QueryPage(queryDTO);
        queryDTO.setIsDelete(JudgeEnum.NO.getValue());
        List<UserDTO> employeeList = userDao.selectUserList(pageParam, queryDTO);

        return ResponseDTO.succData(SmartPageUtil.convert2PageResult(pageParam, employeeList, UserVO.class));
    }

    public ResponseDTO<String> addUser(UserAddDTO employeeAddDto) {
        UserEntity entity = SmartBeanUtil.copy(employeeAddDto, UserEntity.class);
        if (StringUtils.isNotEmpty(employeeAddDto.getIdCard())) {
            boolean checkResult = Pattern.matches(SmartVerificationUtil.ID_CARD, employeeAddDto.getIdCard());
            if (!checkResult) {
                return ResponseDTO.wrap(UserResponseCodeConst.ID_CARD_ERROR);
            }
        }
        if (StringUtils.isNotEmpty(employeeAddDto.getBirthday())) {
            boolean checkResult = Pattern.matches(SmartVerificationUtil.DATE, employeeAddDto.getBirthday());
            if (!checkResult) {
                return ResponseDTO.wrap(UserResponseCodeConst.BIRTHDAY_ERROR);
            }
        }

        //同名用户
        UserDTO sameNameEmployee = userDao.getByLoginName(entity.getLoginName(), UserStatusEnum.NORMAL.getValue());
        if (null != sameNameEmployee) {
            return ResponseDTO.wrap(UserResponseCodeConst.LOGIN_NAME_EXISTS);
        }

        //同电话员工
        UserDTO samePhoneEmployee = userDao.getByPhone(entity.getPhone(), UserStatusEnum.NORMAL.getValue());
        if (null != samePhoneEmployee) {
            return ResponseDTO.wrap(UserResponseCodeConst.PHONE_EXISTS);
        }

        //如果没有密码  默认设置为123456
        String pwd = entity.getLoginPwd();
        if (StringUtils.isBlank(pwd)) {
            entity.setLoginPwd(SmartDigestUtil.encryptPassword(CommonConst.Password.SALT_FORMAT, RESET_PASSWORD));
        } else {
            entity.setLoginPwd(SmartDigestUtil.encryptPassword(CommonConst.Password.SALT_FORMAT, entity.getLoginPwd()));
        }

        if (org.apache.commons.lang3.StringUtils.isEmpty(entity.getBirthday())) {
            entity.setBirthday(null);
        }
        userDao.insert(entity);

        return ResponseDTO.succ();
    }
}
