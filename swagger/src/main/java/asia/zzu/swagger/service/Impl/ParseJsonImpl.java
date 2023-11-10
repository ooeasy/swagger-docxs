package asia.zzu.swagger.service.Impl;

import asia.zzu.swagger.Untils.Json2Map;
import asia.zzu.swagger.mapper.DatabaseMapper;
import asia.zzu.swagger.mapper.WordMapper;
import asia.zzu.swagger.service.ParseJson;
import org.springframework.stereotype.Service;

import java.util.*;

import org.json.JSONObject;

@Service
public class ParseJsonImpl implements ParseJson {

    private final WordMapper wordmapper;
    private final DatabaseMapper databasemapper;

    public ParseJsonImpl(WordMapper wordmapper, DatabaseMapper databasemapper) {
        this.wordmapper = wordmapper;
        this.databasemapper = databasemapper;
    }


    @Override
    public void parseJson(String json_string) {
        Map<String, Object> map;
        JSONObject json = new JSONObject(json_string);
        map = Json2Map.parseJson(json);
        getWord(map);
        updateDatebase(map);
    }

    @Override
    public void getWord(Map<String, Object> map) {
        wordmapper.word(map);
    }

    @Override
    public void updateDatebase(Map<String, Object> map) {
databasemapper.database(map);
    }
}
