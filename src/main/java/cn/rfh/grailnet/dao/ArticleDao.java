package cn.rfh.grailnet.dao;

import cn.rfh.grailnet.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleDao extends JpaRepository<Article,Integer> {
    Article findArticleById(long id);
    List<Article> findArticleByModuleId(long id);
}
