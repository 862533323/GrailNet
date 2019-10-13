package cn.rfh.grailnet.service;

import cn.rfh.grailnet.dao.ArticleDao;
import cn.rfh.grailnet.entity.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {
    @Autowired
    ArticleDao articleDao;
    public Article findArticleById(long id){
        return articleDao.findArticleById(id);
    }

    public Article save(Article article){
        return articleDao.save(article);
    }

    public List<Article> findArticleByModuleId(long id){
        return articleDao.findArticleByModuleId(id);
    }
}
