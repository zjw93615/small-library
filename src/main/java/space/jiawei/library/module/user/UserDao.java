package space.jiawei.library.module.user;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import space.jiawei.library.module.user.domain.dto.UserDTO;
import space.jiawei.library.module.user.domain.dto.UserQueryDTO;
import space.jiawei.library.module.user.domain.entity.UserEntity;

import java.util.Collection;
import java.util.List;

/**
 * 用户dao接口
 *
 * @author lidoudou
 * @date 2017年12月19日下午1:36:30
 */

@Mapper
@Component
public interface UserDao extends BaseMapper<UserEntity> {

    /**
     * 查询用户列表
     * @param page
     * @param queryDTO
     * @return
     */
    List<UserDTO> selectUserList(Page page, @Param("queryDTO") UserQueryDTO queryDTO);

    /**
     * 批量更新禁用状态
     * @param userIds
     * @param isDisabled
     */
    void batchUpdateDisabledStatus(@Param("userIds") List<Long> userIds, @Param("isDisabled") Integer isDisabled);

    /**
     * 登录
     *
     * @param loginName
     * @param loginPwd
     * @return
     */
    UserDTO login(@Param("loginName") String loginName, @Param("loginPwd") String loginPwd);

    /**
     * 通过登录名查询
     *
     * @param loginName
     * @param isDisabled
     * @return
     */
    UserDTO getByLoginName(@Param("loginName") String loginName, @Param("isDisabled") Integer isDisabled);

    /**
     * 通过手机号查询
     *
     * @param phone
     * @param isDisabled
     * @return
     */
    UserDTO getByPhone(@Param("phone") String phone, @Param("isDisabled") Integer isDisabled);

    /**
     * 获取所有用户
     * @return
     */
    List<UserDTO> listAll();

    /**
     * 获取一批员工
     *
     * @param userIds
     * @return
     */
    List<UserDTO> getByIds(@Param("ids") Collection<Long> userIds);

    /**
     * 通过id查询用户
     * @param employeeId
     * @return
     */
    UserDTO getById(@Param("id") Long employeeId);

    /**
     * 用户重置密码
     *
     * @param userId
     * @param password
     * @return
     */
    Integer updatePassword(@Param("userId") Integer userId, @Param("password") String password);
}
