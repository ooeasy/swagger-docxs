package asia.zzu.swagger.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {


    /**
     * 逐层解析 JSON 数据
     *
     * @param jsonObject 要解析的 JSON 对象
     * @throws JSONException 如果解析出错，抛出异常
     */
    public static void parseJson(JSONObject jsonObject) throws JSONException {
        parseJsonObject(jsonObject, "");
    }

    /**
     * 解析 JSON 对象
     *
     * @param jsonObject 要解析的 JSON 对象
     * @param indent     缩进字符串
     * @throws JSONException 如果解析出错，抛出异常
     */
    private static void parseJsonObject(JSONObject jsonObject, String indent) throws JSONException {
        // 遍历 JSON 对象的键值对
        for (String key : jsonObject.keySet()) {
            Object value = jsonObject.get(key);
            if (value instanceof JSONObject) {
                // 如果值是 JSON 对象类型，则递归调用 parseJsonObject 方法进行解析
                System.out.println(indent + key + " (JSONObject):");
                parseJsonObject((JSONObject) value, indent + "\t");
            } else if (value instanceof JSONArray) {
                // 如果值是 JSON 数组类型，则调用 parseJsonArray 方法进行解析
                System.out.println(indent + key + " (JSONArray):");
                parseJsonArray((JSONArray) value, indent + "\t");
            } else {
                // 否则直接输出键值对
                System.out.println(indent + key + ": " + value);
            }
        }
    }

    /**
     * 解析 JSON 数组
     *
     * @param jsonArray 要解析的 JSON 数组
     * @param indent    缩进字符串
     * @throws JSONException 如果解析出错，抛出异常
     */
    private static void parseJsonArray(JSONArray jsonArray, String indent) throws JSONException {
        // 遍历 JSON 数组的元素
        for (int i = 0; i < jsonArray.length(); i++) {
            Object value = jsonArray.get(i);
            if (value instanceof JSONObject) {
                // 如果元素是 JSON 对象类型，则递归调用 parseJsonObject 方法进行解析
                System.out.println(indent + "[" + i + "] (JSONObject):");
                parseJsonObject((JSONObject) value, indent + "\t");
            } else if (value instanceof JSONArray) {
                // 如果元素是 JSON 数组类型，则调用 parseJsonArray 方法进行解析
                System.out.println(indent + "[" + i + "] (JSONArray):");
                parseJsonArray((JSONArray) value, indent + "\t");
            } else {
                // 否则直接输出元素值
                System.out.println(indent + "[" + i + "]: " + value);
            }
        }
    }

    public static void main(String[] args) {
        String jsonStr = "{\"name\":\"John\",\"age\":30,\"cars\":[\"Ford\",\"BMW\",\"Fiat\"],\"address\":{\"street\":\"123 Street\",\"city\":\"New York\"}}";

        String test1="{\n" +
                "  \"swagger\": \"2.0\",\n" +
                "  \"info\": {\n" +
                "    \"description\": \"Swagger文档生成\",\n" +
                "    \"version\": \"v1.0\",\n" +
                "    \"title\": \"Swagger\",\n" +
                "    \"termsOfService\": \"http://terms.service.url/组织链接\",\n" +
                "    \"contact\": {\n" +
                "      \"name\": \"赵庆举\",\n" +
                "      \"url\": \"localhost:8080\",\n" +
                "      \"email\": \"2723734135@qq.com\"\n" +
                "    },\n" +
                "    \"license\": {\n" +
                "      \"name\": \"Apach 2.0 许可\",\n" +
                "      \"url\": \"许可链接\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"host\": \"localhost:8080\",\n" +
                "  \"basePath\": \"/\",\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"name\": \"data-api-client\",\n" +
                "      \"description\": \"Data Api Client\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"hello-controller\",\n" +
                "      \"description\": \"Hello Controller\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"paths\": {\n" +
                "    \"/root\": {\n" +
                "      \"get\": {\n" +
                "        \"tags\": [\n" +
                "          \"data-api-client\"\n" +
                "        ],\n" +
                "        \"summary\": \"root\",\n" +
                "        \"operationId\": \"rootUsingGET\",\n" +
                "        \"produces\": [\n" +
                "          \"*/*\"\n" +
                "        ],\n" +
                "        \"responses\": {\n" +
                "          \"200\": {\n" +
                "            \"description\": \"请求成功\",\n" +
                "            \"schema\": {\n" +
                "              \"type\": \"string\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"401\": {\n" +
                "            \"description\": \"Unauthorized\"\n" +
                "          },\n" +
                "          \"403\": {\n" +
                "            \"description\": \"Forbidden\"\n" +
                "          },\n" +
                "          \"404\": {\n" +
                "            \"description\": \"不存在\"\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    \"/test/hello\": {\n" +
                "      \"get\": {\n" +
                "        \"tags\": [\n" +
                "          \"hello-controller\"\n" +
                "        ],\n" +
                "        \"summary\": \"测试项目是否启动\",\n" +
                "        \"operationId\": \"helloUsingGET\",\n" +
                "        \"produces\": [\n" +
                "          \"*/*\"\n" +
                "        ],\n" +
                "        \"parameters\": [\n" +
                "          {\n" +
                "            \"name\": \"name\",\n" +
                "            \"in\": \"query\",\n" +
                "            \"description\": \"输入名\",\n" +
                "            \"required\": false,\n" +
                "            \"type\": \"string\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"responses\": {\n" +
                "          \"200\": {\n" +
                "            \"description\": \"OK\",\n" +
                "            \"schema\": {\n" +
                "              \"type\": \"string\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"401\": {\n" +
                "            \"description\": \"Unauthorized\"\n" +
                "          },\n" +
                "          \"403\": {\n" +
                "            \"description\": \"Forbidden\"\n" +
                "          },\n" +
                "          \"404\": {\n" +
                "            \"description\": \"Not Found\"\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    },\n" +
                "    \"/test/user\": {\n" +
                "      \"post\": {\n" +
                "        \"tags\": [\n" +
                "          \"hello-controller\"\n" +
                "        ],\n" +
                "        \"summary\": \"user\",\n" +
                "        \"operationId\": \"userUsingPOST\",\n" +
                "        \"consumes\": [\n" +
                "          \"application/json\"\n" +
                "        ],\n" +
                "        \"produces\": [\n" +
                "          \"*/*\"\n" +
                "        ],\n" +
                "        \"responses\": {\n" +
                "          \"200\": {\n" +
                "            \"description\": \"OK\",\n" +
                "            \"schema\": {\n" +
                "              \"$ref\": \"#/definitions/用户实体类\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"201\": {\n" +
                "            \"description\": \"Created\"\n" +
                "          },\n" +
                "          \"401\": {\n" +
                "            \"description\": \"Unauthorized\"\n" +
                "          },\n" +
                "          \"403\": {\n" +
                "            \"description\": \"Forbidden\"\n" +
                "          },\n" +
                "          \"404\": {\n" +
                "            \"description\": \"Not Found\"\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  },\n" +
                "  \"definitions\": {\n" +
                "    \"用户实体类\": {\n" +
                "      \"type\": \"object\",\n" +
                "      \"properties\": {\n" +
                "        \"password\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"description\": \"密码String\"\n" +
                "        },\n" +
                "        \"username\": {\n" +
                "          \"type\": \"string\",\n" +
                "          \"description\": \"用户名String\"\n" +
                "        }\n" +
                "      },\n" +
                "      \"title\": \"用户实体类\"\n" +
                "    }\n" +
                "  }\n" +
                "}";
        String test2="{\n" +
                "  \"swagger\": \"2.0\",\n" +
                "  \"info\": {\n" +
                "    \"description\": \"hello world\",\n" +
                "    \"version\": \"1.0.0\",\n" +
                "    \"title\": \"API文档\"\n" +
                "  },\n" +
                "  \"host\": \"localhost:8080\",\n" +
                "  \"basePath\": \"/\",\n" +
                "  \"tags\": [\n" +
                "    {\n" +
                "      \"name\": \"form-counters-controller\",\n" +
                "      \"description\": \"Form Counters Controller\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"name\": \"test-controller\",\n" +
                "      \"description\": \"Test Controller\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"paths\": {\n" +
                "    \"/doc/string\": {\n" +
                "      \"post\": {\n" +
                "        \"tags\": [\n" +
                "          \"form-counters-controller\"\n" +
                "        ],\n" +
                "        \"summary\": \"测试1\",\n" +
                "        \"description\": \"测试1\",\n" +
                "        \"operationId\": \"testUsingPOST\",\n" +
                "        \"consumes\": [\n" +
                "          \"application/json\"\n" +
                "        ],\n" +
                "        \"produces\": [\n" +
                "          \"*/*\"\n" +
                "        ],\n" +
                "        \"parameters\": [\n" +
                "          {\n" +
                "            \"name\": \"deprecated\",\n" +
                "            \"in\": \"query\",\n" +
                "            \"required\": false,\n" +
                "            \"type\": \"boolean\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"description\",\n" +
                "            \"in\": \"query\",\n" +
                "            \"required\": false,\n" +
                "            \"type\": \"string\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"i\",\n" +
                "            \"in\": \"query\",\n" +
                "            \"description\": \"i\",\n" +
                "            \"required\": true,\n" +
                "            \"type\": \"integer\",\n" +
                "            \"format\": \"int32\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"operationId\",\n" +
                "            \"in\": \"query\",\n" +
                "            \"required\": false,\n" +
                "            \"type\": \"string\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"produces\",\n" +
                "            \"in\": \"query\",\n" +
                "            \"required\": false,\n" +
                "            \"type\": \"array\",\n" +
                "            \"items\": {\n" +
                "              \"type\": \"string\"\n" +
                "            },\n" +
                "            \"collectionFormat\": \"multi\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"responses.code200.description\",\n" +
                "            \"in\": \"query\",\n" +
                "            \"required\": false,\n" +
                "            \"type\": \"string\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"responses.code200.schema.type\",\n" +
                "            \"in\": \"query\",\n" +
                "            \"required\": false,\n" +
                "            \"type\": \"string\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"responses.code401.description\",\n" +
                "            \"in\": \"query\",\n" +
                "            \"required\": false,\n" +
                "            \"type\": \"string\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"responses.code401.schema.type\",\n" +
                "            \"in\": \"query\",\n" +
                "            \"required\": false,\n" +
                "            \"type\": \"string\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"responses.code403.description\",\n" +
                "            \"in\": \"query\",\n" +
                "            \"required\": false,\n" +
                "            \"type\": \"string\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"responses.code403.schema.type\",\n" +
                "            \"in\": \"query\",\n" +
                "            \"required\": false,\n" +
                "            \"type\": \"string\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"responses.code404.description\",\n" +
                "            \"in\": \"query\",\n" +
                "            \"required\": false,\n" +
                "            \"type\": \"string\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"responses.code404.schema.type\",\n" +
                "            \"in\": \"query\",\n" +
                "            \"required\": false,\n" +
                "            \"type\": \"string\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"summary\",\n" +
                "            \"in\": \"query\",\n" +
                "            \"required\": false,\n" +
                "            \"type\": \"string\"\n" +
                "          },\n" +
                "          {\n" +
                "            \"name\": \"tags\",\n" +
                "            \"in\": \"query\",\n" +
                "            \"required\": false,\n" +
                "            \"type\": \"array\",\n" +
                "            \"items\": {\n" +
                "              \"type\": \"string\"\n" +
                "            },\n" +
                "            \"collectionFormat\": \"multi\"\n" +
                "          }\n" +
                "        ],\n" +
                "        \"responses\": {\n" +
                "          \"200\": {\n" +
                "            \"description\": \"OK\",\n" +
                "            \"schema\": {\n" +
                "              \"type\": \"string\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"201\": {\n" +
                "            \"description\": \"Created\"\n" +
                "          },\n" +
                "          \"401\": {\n" +
                "            \"description\": \"Unauthorized\"\n" +
                "          },\n" +
                "          \"403\": {\n" +
                "            \"description\": \"Forbidden\"\n" +
                "          },\n" +
                "          \"404\": {\n" +
                "            \"description\": \"Not Found\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"deprecated\": false\n" +
                "      }\n" +
                "    },\n" +
                "    \"/doc/text\": {\n" +
                "      \"get\": {\n" +
                "        \"tags\": [\n" +
                "          \"form-counters-controller\"\n" +
                "        ],\n" +
                "        \"summary\": \"处理json文档\",\n" +
                "        \"description\": \"处理json文档\",\n" +
                "        \"operationId\": \"FormCounters1UsingGET\",\n" +
                "        \"produces\": [\n" +
                "          \"*/*\"\n" +
                "        ],\n" +
                "        \"responses\": {\n" +
                "          \"200\": {\n" +
                "            \"description\": \"OK\",\n" +
                "            \"schema\": {\n" +
                "              \"type\": \"string\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"401\": {\n" +
                "            \"description\": \"Unauthorized\"\n" +
                "          },\n" +
                "          \"403\": {\n" +
                "            \"description\": \"Forbidden\"\n" +
                "          },\n" +
                "          \"404\": {\n" +
                "            \"description\": \"Not Found\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"deprecated\": false\n" +
                "      }\n" +
                "    },\n" +
                "    \"/test/first\": {\n" +
                "      \"get\": {\n" +
                "        \"tags\": [\n" +
                "          \"test-controller\"\n" +
                "        ],\n" +
                "        \"summary\": \"first\",\n" +
                "        \"description\": \"first\",\n" +
                "        \"operationId\": \"fisrtUsingGET\",\n" +
                "        \"produces\": [\n" +
                "          \"*/*\"\n" +
                "        ],\n" +
                "        \"responses\": {\n" +
                "          \"200\": {\n" +
                "            \"description\": \"OK\",\n" +
                "            \"schema\": {\n" +
                "              \"type\": \"string\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"401\": {\n" +
                "            \"description\": \"Unauthorized\"\n" +
                "          },\n" +
                "          \"403\": {\n" +
                "            \"description\": \"Forbidden\"\n" +
                "          },\n" +
                "          \"404\": {\n" +
                "            \"description\": \"Not Found\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"deprecated\": false\n" +
                "      }\n" +
                "    },\n" +
                "    \"/test/second\": {\n" +
                "      \"get\": {\n" +
                "        \"tags\": [\n" +
                "          \"test-controller\"\n" +
                "        ],\n" +
                "        \"summary\": \"second\",\n" +
                "        \"description\": \"second\",\n" +
                "        \"operationId\": \"secondUsingGET\",\n" +
                "        \"produces\": [\n" +
                "          \"*/*\"\n" +
                "        ],\n" +
                "        \"responses\": {\n" +
                "          \"200\": {\n" +
                "            \"description\": \"OK\",\n" +
                "            \"schema\": {\n" +
                "              \"type\": \"string\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"401\": {\n" +
                "            \"description\": \"Unauthorized\"\n" +
                "          },\n" +
                "          \"403\": {\n" +
                "            \"description\": \"Forbidden\"\n" +
                "          },\n" +
                "          \"404\": {\n" +
                "            \"description\": \"Not Found\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"deprecated\": false\n" +
                "      }\n" +
                "    },\n" +
                "    \"/test/third\": {\n" +
                "      \"get\": {\n" +
                "        \"tags\": [\n" +
                "          \"test-controller\"\n" +
                "        ],\n" +
                "        \"summary\": \"third\",\n" +
                "        \"description\": \"third\",\n" +
                "        \"operationId\": \"thirdUsingGET\",\n" +
                "        \"produces\": [\n" +
                "          \"*/*\"\n" +
                "        ],\n" +
                "        \"responses\": {\n" +
                "          \"200\": {\n" +
                "            \"description\": \"OK\",\n" +
                "            \"schema\": {\n" +
                "              \"type\": \"string\"\n" +
                "            }\n" +
                "          },\n" +
                "          \"401\": {\n" +
                "            \"description\": \"Unauthorized\"\n" +
                "          },\n" +
                "          \"403\": {\n" +
                "            \"description\": \"Forbidden\"\n" +
                "          },\n" +
                "          \"404\": {\n" +
                "            \"description\": \"Not Found\"\n" +
                "          }\n" +
                "        },\n" +
                "        \"deprecated\": false\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}";
        try {
            JSONObject jsonObject = new JSONObject(test1);
            parseJson(jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
