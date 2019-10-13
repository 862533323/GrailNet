package cn.rfh.grailnet.controller;

import cn.rfh.grailnet.entity.Article;
import cn.rfh.grailnet.entity.Module;
import cn.rfh.grailnet.service.ArticleService;
import cn.rfh.grailnet.service.ModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ModuleController extends BaseController{
    @Autowired
    ModuleService moduleService;

    @Autowired
    ArticleService articleService;
    @RequestMapping(value = "/module/items")
    public String getModuleItem(@Nullable Long id, @Nullable String name){
        rebuildJSONObject();
        List<Module> list;
        if (id==null){
            list=moduleService.findModuleByNameLike(name);
        }else {
            list=new ArrayList<>();
            list.add(moduleService.findModuleById(id));
        }
        return jsonObject.put("module",list).toString();
    }

    @RequestMapping("/module")
    public String getModule(@Nullable Integer id, @Nullable String name){
        rebuildJSONObject();
        Module module;
        if (id==null){
            module=moduleService.findModuleByName(name);
        }else {
            module=moduleService.findModuleById(id);
        }
        return jsonObject.put("module",module).toString();
    }

    @RequestMapping("/moudule/submodule/items")
    public String getSubModuleItems(){
        rebuildJSONObject();
        List<Module> modules=moduleService.findAll();
        List<Map> list=new ArrayList<>();
        Map<String,Object> map;
        for (Module module:modules){
            map=new HashMap<>();
            map.put("id",module.getId());
            map.put("name",module.getName());
            map.put("title",module.getTitle());
            map.put("submodules",moduleService.findSubModuleParentId(module.getId()));
            list.add(map);
        }
        return jsonObject.put("modules",list).toString();
    }

    @RequestMapping("/module/articleType/items")
    public String getArticleType(Long id){
        rebuildJSONObject();
        List<Map> list=new ArrayList<>();
        Map<String ,Object> map;
        for (Article article:articleService.findArticleByModuleId(id)){
            map=new HashMap<>();
            map.put("id",article.getId());
            map.put("name",article.getTypeId());
            list.add(map);
        }
        return jsonObject.put("items",list).toString();
    }
}
