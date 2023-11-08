package asia.zzu.swagger.Untils;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Json2Map {
    static String test1 = "{\n" +
            "    \"swagger\": \"2.0\",\n" +
            "    \"info\": {\n" +
            "        \"description\": \"Swagger文档生成\",\n" +
            "        \"version\": \"v1.0\",\n" +
            "        \"title\": \"Swagger\",\n" +
            "        \"termsOfService\": \"http://terms.service.url/组织链接\",\n" +
            "        \"contact\": {\n" +
            "            \"name\": \"赵庆举\",\n" +
            "            \"url\": \"localhost:8080\",\n" +
            "            \"email\": \"2723734135@qq.com\"\n" +
            "        },\n" +
            "        \"license\": {\n" +
            "            \"name\": \"Apach 2.0 许可\",\n" +
            "            \"url\": \"许可链接\"\n" +
            "        }\n" +
            "    },\n" +
            "    \"host\": \"localhost:8080\",\n" +
            "    \"basePath\": \"/\",\n" +
            "    \"tags\": [\n" +
            "        {\n" +
            "            \"name\": \"data-api-client\",\n" +
            "            \"description\": \"Data Api Client\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"name\": \"hello-controller\",\n" +
            "            \"description\": \"Hello Controller\"\n" +
            "        }\n" +
            "    ],\n" +
            "    \"paths\": {\n" +
            "        \"/root\": {\n" +
            "            \"get\": {\n" +
            "                \"tags\": [\n" +
            "                    \"data-api-client\"\n" +
            "                ],\n" +
            "                \"summary\": \"root\",\n" +
            "                \"operationId\": \"rootUsingGET\",\n" +
            "                \"produces\": [\n" +
            "                    \"*/*\"\n" +
            "                ],\n" +
            "                \"responses\": {\n" +
            "                    \"200\": {\n" +
            "                        \"description\": \"请求成功\",\n" +
            "                        \"schema\": {\n" +
            "                            \"type\": \"string\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    \"401\": {\n" +
            "                        \"description\": \"Unauthorized\"\n" +
            "                    },\n" +
            "                    \"403\": {\n" +
            "                        \"description\": \"Forbidden\"\n" +
            "                    },\n" +
            "                    \"404\": {\n" +
            "                        \"description\": \"不存在\"\n" +
            "                    }\n" +
            "                }\n" +
            "            }\n" +
            "        },\n" +
            "        \"/test/hello\": {\n" +
            "            \"get\": {\n" +
            "                \"tags\": [\n" +
            "                    \"hello-controller\"\n" +
            "                ],\n" +
            "                \"summary\": \"测试项目是否启动\",\n" +
            "                \"operationId\": \"helloUsingGET\",\n" +
            "                \"produces\": [\n" +
            "                    \"*/*\"\n" +
            "                ],\n" +
            "                \"parameters\": [\n" +
            "                    {\n" +
            "                        \"name\": \"name\",\n" +
            "                        \"in\": \"query\",\n" +
            "                        \"description\": \"输入名\",\n" +
            "                        \"required\": false,\n" +
            "                        \"type\": \"string\"\n" +
            "                    }\n" +
            "                ],\n" +
            "                \"responses\": {\n" +
            "                    \"200\": {\n" +
            "                        \"description\": \"OK\",\n" +
            "                        \"schema\": {\n" +
            "                            \"type\": \"string\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    \"401\": {\n" +
            "                        \"description\": \"Unauthorized\"\n" +
            "                    },\n" +
            "                    \"403\": {\n" +
            "                        \"description\": \"Forbidden\"\n" +
            "                    },\n" +
            "                    \"404\": {\n" +
            "                        \"description\": \"Not Found\"\n" +
            "                    }\n" +
            "                }\n" +
            "            }\n" +
            "        },\n" +
            "        \"/test/user\": {\n" +
            "            \"post\": {\n" +
            "                \"tags\": [\n" +
            "                    \"hello-controller\"\n" +
            "                ],\n" +
            "                \"summary\": \"user\",\n" +
            "                \"operationId\": \"userUsingPOST\",\n" +
            "                \"consumes\": [\n" +
            "                    \"application/json\"\n" +
            "                ],\n" +
            "                \"produces\": [\n" +
            "                    \"*/*\"\n" +
            "                ],\n" +
            "                \"responses\": {\n" +
            "                    \"200\": {\n" +
            "                        \"description\": \"OK\",\n" +
            "                        \"schema\": {\n" +
            "                            \"$ref\": \"#/definitions/用户实体类\"\n" +
            "                        }\n" +
            "                    },\n" +
            "                    \"201\": {\n" +
            "                        \"description\": \"Created\"\n" +
            "                    },\n" +
            "                    \"401\": {\n" +
            "                        \"description\": \"Unauthorized\"\n" +
            "                    },\n" +
            "                    \"403\": {\n" +
            "                        \"description\": \"Forbidden\"\n" +
            "                    },\n" +
            "                    \"404\": {\n" +
            "                        \"description\": \"Not Found\"\n" +
            "                    }\n" +
            "                }\n" +
            "            }\n" +
            "        }\n" +
            "    },\n" +
            "    \"definitions\": {\n" +
            "        \"用户实体类\": {\n" +
            "            \"type\": \"object\",\n" +
            "            \"properties\": {\n" +
            "                \"password\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"description\": \"密码String\"\n" +
            "                },\n" +
            "                \"username\": {\n" +
            "                    \"type\": \"string\",\n" +
            "                    \"description\": \"用户名String\"\n" +
            "                }\n" +
            "            },\n" +
            "            \"title\": \"用户实体类\"\n" +
            "        }\n" +
            "    }\n" +
            "}";

    public static Map<String, Object> parseJson(JSONObject json) {
        Map<String, Object> resultMap = new HashMap<>();
        for (String key : json.keySet()) {
            Object value = json.get(key);

            if (value instanceof JSONObject) {
                resultMap.put(key, parseJson((JSONObject) value));
            } else if (value instanceof JSONArray) {
                JSONArray array = (JSONArray) value;
                Object[] resultArray = new Object[array.length()];
                for (int i = 0; i < array.length(); i++) {
                    if (array.get(i) instanceof JSONObject) {
                        resultArray[i] = parseJson(array.getJSONObject(i));
                    } else {
                        resultArray[i] = array.get(i);
                    }
                }
                resultMap.put(key, resultArray);
            } else {
                resultMap.put(key, value);
            }
        }
        return resultMap;
    }

    public static void main(String[] args) {
        String jsonString = "{\"name\": \"John\", \"age\": 30, \"address\": {\"city\": \"New York\", \"zip\": \"10001\"}, \"hobbies\": [\"reading\", \"hiking\"]}";

        JSONObject jsonObject = new JSONObject(test1);
        Map<String, Object> map = parseJson(jsonObject);
        Object[] list = (Object[]) map.get("tags");
        for (Object tag : list) {
            System.out.println((Map<String, Object>) tag);
        }
    }
}