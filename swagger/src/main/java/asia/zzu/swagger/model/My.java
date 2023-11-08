package asia.zzu.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("我的实体类")
public class My {
    @ApiModelProperty("我的名字")
    private String myName;

    public My(String myName) {
        this.myName = myName;
    }

    public My() {

    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyName() {
        return myName;
    }
}
