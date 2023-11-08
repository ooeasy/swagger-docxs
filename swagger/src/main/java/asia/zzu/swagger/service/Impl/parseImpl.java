package asia.zzu.swagger.service.Impl;

import asia.zzu.swagger.Untils.Json2Map;
import asia.zzu.swagger.Untils.Json2Map副本;
import asia.zzu.swagger.service.parse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import org.json.JSONObject;

@Service
public class parseImpl implements parse {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private asia.zzu.swagger.mapper.word word;

    public Map<String, Object> map;

    @Override
    public void parseJson(String json_string) {
        /*
        try {
            map = objectMapper.readValue(json, Map.class);
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
         */

        JSONObject json = new JSONObject(json_string);

        map = Json2Map.parseJson(json);

        getWord(map);
        updateDatebase(map);
    }
/*
    public static Map<String, Object> parseJSON2Map(JSONObject json) {
        Map<String, Object> map = new HashMap<String, Object>();
        // 最外层解析
        for (Object k : json.keySet()) {
            Object v = json.get(String.valueOf(k));
            // 如果内层还是json数组的话，继续解析
            if (v instanceof JSONArray) {
               /* List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
                Iterator<JSONObject> it = ((JSONArray) v).iterator();
                while (it.hasNext()) {
                    JSONObject json2 = it.next();
                    list.add(parseJSON2Map(json2));
                }
                map.put(k.toString(), list);
            } else if (v instanceof JSONObject) {
                // 如果内层是json对象的话，继续解析
                map.put(k.toString(), parseJSON2Map((JSONObject) v));
            } else {
                // 如果内层是普通对象的话，直接放入map中
                map.put(k.toString(), v);
            }
        }
        return map;
    }
*/

    @Override
    public void getWord(Map<String, Object> map) {
        word.word(map);
    }

    @Override
    public void updateDatebase(Map<String, Object> map) {

    }
}
