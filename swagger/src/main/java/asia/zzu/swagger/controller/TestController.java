package asia.zzu.swagger.controller;

import asia.zzu.swagger.model.Father;
import asia.zzu.swagger.model.My;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("/测试路经")
@RequestMapping("/my")
@RestController
public class TestController {


    @PostMapping("/my")
    public My my() {
        return new My();
    }

    @GetMapping("/father")
    public Father father(){
        return new Father();
    }
}
