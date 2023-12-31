package asia.zuu.springweb;

import asia.zuu.springweb.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/springBoot/student")
    public @ResponseBody Object student() {

        Student student = studentService.queryStudentById(1);

        return student;
    }
}