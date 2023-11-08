package asia.zzu.swagger.controller;

import asia.zzu.swagger.service.Impl.parseImpl;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DataApiClient {
    @Autowired
    RestTemplate restTemplate;
    @Autowired
    parseImpl parseimpl;


    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 404, message = "不存在")
    })
    @GetMapping("/root")
    public String root() {
        String apiUrl = "http://localhost:8080/v2/api-docs"; // 接口 URL
        String Url="https://petstore.swagger.io/v2/swagger.json";
        String responseJson = restTemplate.getForObject(Url, String.class);
        parseimpl.parseJson(responseJson);

        return responseJson;
    }

}
