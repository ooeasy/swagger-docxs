package asia.zzu.swagger.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

@Mapper
@Component
public class WordMapper {
    public boolean word(Map<String, Object> map) {
        XWPFDocument document = new XWPFDocument();
        // 创建段落
        XWPFParagraph paragraph1 = document.createParagraph();
        XWPFRun run = paragraph1.createRun();
        run.setText("Hello, World!");
        run.addBreak();
        run.setText("Swagger" + (String) map.get("swagger"));
        Map info = (Map) map.get("info");
        run.addBreak();
        run.setText((String) info.get("description"));
        run.setText("  版本：" + (String) info.get("version"));
        run.addBreak();
        run.setText("Terms of service:" + (String) info.get("termsOfService"));
        run.addBreak();
        run.setText("开源许可：" + (String) ((Map) info.get("license")).get("name"));
        run.addBreak();
        run.setText("Host:Port/context：" + map.get("host") + map.get("basePath"));
        run.addBreak();
        run.addBreak();
        paragraph1.setAlignment(ParagraphAlignment.LEFT);
        XWPFParagraph paragraph2 = document.createParagraph();
        XWPFRun run2 = paragraph2.createRun();
        run2.setText("Controller控制器：");
        run2.addBreak();
        Object[] tags = (Object[]) map.get("tags");
        for (Object tag : tags) {
            Map map1 = (Map) tag;
            run2.setText("名称");
            run2.setBold(true);
            run2.setText((String) map1.get("name"));
            run2.setText("     类名@");
            run2.setBold(true);
            run2.setText((String) map1.get("description"));
            run2.addBreak();
        }
        paragraph2.setAlignment(ParagraphAlignment.LEFT);
        XWPFParagraph paragraph3 = document.createParagraph();
        XWPFRun run3 = paragraph3.createRun();
        Map paths = (Map) map.get("paths");
        Set<String> pathList = paths.keySet();
        for (String url : pathList) {
            Map api = (Map) paths.get(url);
            Set<String> methods = api.keySet();
            for (String methodKey : methods) {
                Map method = (Map) api.get(methodKey);
                run3.setText("摘要：" + method.get("summary"));
                run3.addBreak();
                run3.setText("访问路经：" + url + "       访问方法:" + methodKey);
                run3.addBreak();
                Object[] apiTags = (Object[]) method.get("tags");
                run3.setText("所处的控制类：" + (String) apiTags[0]);
                run3.addBreak();
                run3.setText("客户端请求：：");
                run3.addBreak();
                Object[] parameterList = (Object[]) method.get("parameters");
                if (parameterList==null){
                    break;
                }
                for (Object obj : parameterList) {
                    Map parameter = (Map) obj;
                    run3.setText("属性名：" + parameter.get("name"));
                    run3.setText("  ｜  in:" + parameter.get("in"));
                    run3.setText("  ｜  简介:" + parameter.get("description"));
                    run3.addBreak();
                    run3.setText("required:" + parameter.get("required"));
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
                }
            }
            run3.addBreak();
            run3.setText("===");
            run3.addBreak();
            run3.addBreak();
        }
        paragraph3.setAlignment(ParagraphAlignment.LEFT);
        try (FileOutputStream out = new FileOutputStream("swagger-api.docx")) {
            document.write(out);
            System.out.println("Word文档生成成功！");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
