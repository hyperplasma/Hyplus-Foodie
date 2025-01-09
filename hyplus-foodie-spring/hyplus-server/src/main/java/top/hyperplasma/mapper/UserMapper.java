package top.hyperplasma.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import top.hyperplasma.entity.User;

@Mapper
public interface UserMapper {

    /**
     * 根据openid查询用户
     *
     * @param openid
     * @return User
     */
    @Select("select * from user where openid = #{openid}")
    User getByOpenid(String openid);

    /**
     * 插入用户
     *
     * @param user
     */
    void insert(User user);

    /**
     * 根据id查询用户
     *
     * @param userId
     * @return User
     */
    @Select("select * from user where id = #{userId}")
    User getById(Long userId);
}
