package cn.rfh.grailnet.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "reply")
public class Reply extends BaseEntity{
    private long commentId;
    private long userId;
    private long receiverId;
    private String content;
    private String createTime;
}
