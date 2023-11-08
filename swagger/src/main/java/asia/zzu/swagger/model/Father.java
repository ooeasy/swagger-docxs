package asia.zzu.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("父亲实体类")
public class Father {
    @ApiModelProperty("父亲的的名字")
    private String fatherName;

    @ApiModelProperty("关联测试类")
    private My my;

    public Father(String fatherName, My my) {
        this.fatherName = fatherName;
        this.my = my;
    }

    public Father() {

    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public My getMy() {
        return my;
    }

    public void setMy(My my) {
        this.my = my;
    }
}
