package asia.zzu.swagger.controller;

import asia.zzu.swagger.mapper.UniAclTreeMapper;
import asia.zzu.swagger.model.UniAclTree;
import asia.zzu.swagger.service.Impl.ParseJsonImpl;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DataApiClient {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    ParseJsonImpl parseimpl;
    @Autowired
    UniAclTreeMapper datebase;

    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 404, message = "不存在")
    })
    @GetMapping("/root")
    public String root() {
        String apiUrl = "http://localhost:8080/v2/api-docs"; // 接口 URL
        String Url = "https://petstore.swagger.io/v2/swagger.json";
        String responseJson = restTemplate.getForObject(apiUrl, String.class);
        parseimpl.parseJson(responseJson);

        return responseJson;
    }

    @GetMapping("/tree")
    public String Tree() {
        int line = 0;
        UniAclTree uniAclTree = new UniAclTree("白冰玉", "牛逼", 123, 456);
        line=datebase.insert(uniAclTree);
        return String.valueOf(line);
    }

}
