package asia.zzu.swagger.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.hibernate.annotations.Table;

import javax.persistence.Entity;

@TableName("uni_acl_tree")
public class UniAclTree {
    @TableId(type = IdType.AUTO)
    private long id;
    private String name;
    private String description;
    private long pid;
    private long seqno;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public long getPid() {
        return pid;
    }

    public void setPid(long pid) {
        this.pid = pid;
    }


    public long getSeqno() {
        return seqno;
    }

    public void setSeqno(long seqno) {
        this.seqno = seqno;
    }

    public UniAclTree(String name, String description, long pid, long seqno) {
        this.name = name;
        this.description = description;
        this.pid = pid;
        this.seqno = seqno;
    }
}
