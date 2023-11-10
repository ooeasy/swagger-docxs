package asia.zzu.swagger.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("uni_acl_url")
public class UniAclUrl {
    @TableId(type = IdType.AUTO)
    private long id;
    private String urlpattern;
    private String name;
    private String cname;
    private String description;
    private long tid;
    private String method;
    private long pid;
    private long msid;
    private String mustgrant;
    private String enabled;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getUrlpattern() {
        return urlpattern;
    }

    public void setUrlpattern(String urlpattern) {
        this.urlpattern = urlpattern;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }


    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }


    public long getMsid() {
        return msid;
    }

    public void setMsid(long msid) {
        this.msid = msid;
    }


    public String getMustgrant() {
        return mustgrant;
    }

    public void setMustgrant(String mustgrant) {
        this.mustgrant = mustgrant;
    }


    public String getEnabled() {
        return enabled;
    }

    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }


}
