package cn.rfh.grailnet.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "comment")
@Entity
public class Comment extends BaseEntity{
    private long articleId;
    private long userId;
    private String content;
    private String createTime;
}
