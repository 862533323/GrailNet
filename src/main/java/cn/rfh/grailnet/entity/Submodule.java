package cn.rfh.grailnet.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "submodule")
public class Submodule extends BaseEntity{
    private String name;
    private String description;
    private int count;
    private String title;
    private String avatar;
    private long parentId;
}
