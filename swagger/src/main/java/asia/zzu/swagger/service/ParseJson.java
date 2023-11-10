package asia.zzu.swagger.service;

import java.util.Map;

public interface ParseJson {
    public void parseJson(String json);
    public void getWord(Map<String, Object> map);
    public void updateDatebase(Map<String, Object> map);
}