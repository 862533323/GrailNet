package cn.rfh.grailnet.service;

import cn.rfh.grailnet.dao.ModuleDao;
import cn.rfh.grailnet.dao.SubmoduleDao;
import cn.rfh.grailnet.entity.Module;
import cn.rfh.grailnet.entity.Submodule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuleService {
    @Autowired
    ModuleDao moduleDao;
    @Autowired
    SubmoduleDao submoduleDao;
    public Module findModuleById(long id){
        return moduleDao.findModuleById(id);
    }

    public Module save(Module module){
        return moduleDao.save(module);
    }

    public List<Module> findModuleByNameLike(String name){
        return moduleDao.findModuleByNameLike(name);
    }

    public Module findModuleByName(String name){
        return moduleDao.findModuleByName(name);
    }

    public List<Module> findAll(){
        return moduleDao.findAll();
    }

    public List<Submodule> findSubModuleParentId(long id){
        return submoduleDao.findSubmoduleByParentId(id);
    }
}
