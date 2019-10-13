package cn.rfh.grailnet.dao;

import cn.rfh.grailnet.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    User findUserById(long id);
    User findUserByPhone(String phone);
    User findUserByAccount(String account);
    User findUserByName(String name);
}
