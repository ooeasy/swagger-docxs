package asia.zzu.swagger.controller;

import asia.zzu.swagger.model.Father;
import asia.zzu.swagger.model.My;
import asia.zzu.swagger.model.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

@Api("/测试路经Hello")
@RequestMapping("/test")
@RestController
public class HelloController {

    @ApiOperation("测试项目是否启动")
    @GetMapping("/hello")
    public String hello(@ApiParam("输入名") String name) {
        return "hello";
    }

    @PostMapping("/user")
    public User user(@ApiParam("没用的属性1") String no1,@ApiParam("没用的属性2") Father no2) {
        return new User();
    }
}
