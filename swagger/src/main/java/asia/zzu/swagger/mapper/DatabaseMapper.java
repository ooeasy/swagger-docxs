package asia.zzu.swagger.mapper;

import asia.zzu.swagger.model.UniAclTree;
import asia.zzu.swagger.model.UniAclUrl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Mapper
@Component
public class DatabaseMapper {
    @Autowired
    UniAclTreeMapper uniAclTreeMapper;
    @Autowired
    UniAclUrlMapper uniAclUrlMapper;
    private UniAclTree uniAclTree;
    private UniAclUrl uniAclUrl;

    public int database(Map<String, Object> map) {

        Map info = (Map) map.get("info");
        Object[] tagList = (Object[]) map.get("tags");
        for (Object tagKey : tagList) {
            Map tag = (Map) tagKey;
            int i = 1;
            System.out.println(tag.get("description"));
            uniAclTree.setDescription((String) tag.get("description"));
            uniAclTree.setName((String) tag.get("name"));
            uniAclTree.setSeqno(i);
            uniAclTreeMapper.insert(uniAclTree);
        }


        List<UniAclTree> uniAclTreeList=uniAclTreeMapper.selectList(null);



        Map paths = (Map) map.get("paths");
        Set<String> pathList = paths.keySet();
        for (String url : pathList) {
            Map api = (Map) paths.get(url);
            Set<String> methods = api.keySet();
            for (String methodKey : methods) {
                Map method = (Map) api.get(methodKey);
                uniAclUrl.setMethod(methodKey);
                uniAclUrl.setUrlpattern(url);
                uniAclUrl.setDescription((String) method.get("description"));
                uniAclTree.setName((String) method.get("summary"));
                uniAclTree.setDescription((String) method.get("description"));
                Object[] apiTags = (Object[]) method.get("tags");
                for (Object obj:apiTags){
                    String name=obj.toString();
                    for (UniAclTree uniAclTree1:uniAclTreeList){
                        if (name.equals(uniAclTree1.getName())){
                            int pid= (int) uniAclTree1.getId();
                            uniAclTree.setPid(pid);
                            uniAclTreeMapper.insert(uniAclTree);
                        }
                    }



                }
                /*
                Object[] parameterList = (Object[]) method.get("parameters");
                for (Object obj : parameterList) {
                    Map parameter = (Map) obj;
                    if (parameter.containsKey("type")) {
                        run3.setText("  |  类型" + parameter.get("type"));
                        run3.addBreak();
                    } else {
                        run3.setText("  |  " + ((Map) parameter.get("schema")).get("type"));
                        run3.addBreak();
                    }
                }
                Map definitions = (Map) map.get("definitions");
                Map responses = (Map) method.get("responses");
                run3.setText("服务器响应：：");
                run3.addBreak();
                Set<String> codeList = responses.keySet();
                for (String codeKey : codeList) {
                    if ("200".equals(codeKey)) {
                        Map code200 = (Map) responses.get("200");
                        Map schema = (Map) code200.get("schema");
                        Set<String> type = schema.keySet();
                        run3.setText("200:" + code200.get("description") + "  |  响应类型：");
                        for (String respType : type) {
                            if ("$ref".equals(respType)) {
                                String moudleName = ((String) schema.get("$ref")).substring(14);
                                Map moudle = (Map) definitions.get(moudleName);
                                run3.setText((String) moudle.get("type") + ":" + moudleName);
                                run3.addBreak();
                                Map properties = (Map) moudle.get("properties");
                                Set<String> propertieList = properties.keySet();
                                for (String propertieKey : propertieList) {
                                    Map property = (Map) properties.get(propertieKey);
                                    run3.setText(propertieKey + " : 类型@" + property.get("type") + "、介绍@" + property.get("description"));
                                    run3.addBreak();
                                }
                            } else if ("type".equals(respType)) {
                                run3.setText((String) schema.get("type"));
                                run3.addBreak();
                            }
                        }
                    } else {
                        run3.setText(codeKey + ":" + ((Map) responses.get(codeKey)).get("description"));
                        run3.addBreak();
                    }
                }*/
            }

        }
        try (FileOutputStream out = new FileOutputStream("swagger-api.docx")) {
            System.out.println("数据库插入成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return 1;
    }
}
