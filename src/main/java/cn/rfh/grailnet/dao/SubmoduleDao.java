package cn.rfh.grailnet.dao;

import cn.rfh.grailnet.entity.Submodule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmoduleDao extends JpaRepository<Submodule,Integer> {
    Submodule findSubmoduleById(long id);
    List<Submodule> findSubmoduleByParentId(long id);
}
