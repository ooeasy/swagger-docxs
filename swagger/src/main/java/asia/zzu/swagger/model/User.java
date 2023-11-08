package asia.zzu.swagger.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("用户实体类")
public class User {
    @ApiModelProperty("用户名String")
    public String username;
    @ApiModelProperty("密码String")
    public String password;
}