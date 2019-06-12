package com.ruler.fighting.bean;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

/**
 * name:SailCheung
 * date:2019-06-13
 * time:上午 12:50
 * year:2019
 * project_name:fighting
 */
@Entity
public class CollectBean {
    @Id(autoincrement = true)
    private Long id;
    private String url;
    private String desc;
    @Generated(hash = 343328188)
    public CollectBean(Long id, String url, String desc) {
        this.id = id;
        this.url = url;
        this.desc = desc;
    }
    @Generated(hash = 420494524)
    public CollectBean() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUrl() {
        return this.url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getDesc() {
        return this.desc;
    }
    public void setDesc(String desc) {
        this.desc = desc;
    }
}
