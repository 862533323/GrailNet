package cn.rfh.grailnet.dao;

import cn.rfh.grailnet.entity.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ModuleDao extends JpaRepository<Module,Integer> {
    Module findModuleById(long id);
    List<Module> findAll();
    List<Module> findModuleByNameLike(String name);
    Module findModuleByName(String name);
}
