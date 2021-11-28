package com.example.blog.pojo;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_blog")
public class Blog {
    @Id
    @GeneratedValue
    private Long id;           //唯一的查询id

	private String tile;       //标题
	private String content;      //内容
	private String cover;        //封面
	private Date createTime;  //创建时间
	private Date editTime;    //最后修改时间
    private boolean published;  //是否发布

    @ManyToOne
    private Type type;

    @ManyToMany(cascade = {CascadeType.PERSIST})
    private List<Tag> tags = new ArrayList<>();

    public Blog() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTile(String tile) {
        this.tile = tile;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public void setCreateTime(Date create_time) {
        this.createTime = create_time;
    }

    public void setEditTime(Date edit_time) {
        this.editTime = edit_time;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public Long getId() {
        return id;
    }

    public String getTile() {
        return tile;
    }

    public String getContent() {
        return content;
    }

    public String getCover() {
        return cover;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getEditTime() {
        return editTime;
    }

    public boolean isPublished() {
        return published;
    }
}
