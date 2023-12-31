package asia.zuu.springweb.service;

import asia.zuu.springweb.Student;

public interface StudentService {
    /**
     * 根据学生标识获取学生详情
     *
     * @param id
     * @return
     */
    Student queryStudentById(Integer id);
}
