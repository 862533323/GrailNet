package cn.rfh.grailnet.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article extends BaseEntity {
    private long moduleId;
    private long submoduleId;
    private long typeId;
    private String description;
    private String title;
    private String content;
    private String writer;
    private long writerId;
    private String theme;
    private String updateTime;
    private String createTime;
    private long watchCount;
    private long goodCount;

    public long getSubmoduleId() {
        return submoduleId;
    }

    public void setSubmoduleId(long submoduleId) {
        this.submoduleId = submoduleId;
    }

    public long getModuleId() {
        return moduleId;
    }

    public void setModuleId(long moduleId) {
        this.moduleId = moduleId;
    }

    public long getTypeId() {
        return typeId;
    }

    public void setTypeId(long typeId) {
        this.typeId = typeId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public long getWriterId() {
        return writerId;
    }

    public void setWriterId(long writerId) {
        this.writerId = writerId;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public long getWatchCount() {
        return watchCount;
    }

    public void setWatchCount(long watchCount) {
        this.watchCount = watchCount;
    }

    public long getGoodCount() {
        return goodCount;
    }

    public void setGoodCount(long goodCount) {
        this.goodCount = goodCount;
    }
}
