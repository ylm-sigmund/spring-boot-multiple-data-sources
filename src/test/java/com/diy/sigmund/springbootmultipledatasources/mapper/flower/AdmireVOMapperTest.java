package com.diy.sigmund.springbootmultipledatasources.mapper.flower;

import java.util.List;
import java.util.Objects;

import com.diy.sigmund.springbootmultipledatasources.util.ProfileUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.diy.sigmund.springbootmultipledatasources.entity.AdmireDO;
import com.diy.sigmund.springbootmultipledatasources.entity.StudentDO;
import com.diy.sigmund.springbootmultipledatasources.entity.TeacherDO;
import com.diy.sigmund.springbootmultipledatasources.mapper.deploy.TeacherMapper;
import com.diy.sigmund.springbootmultipledatasources.mapper.web.StudentMapper;

/**
 * @author ylm-sigmund
 * @since 2020/8/19 22:12
 */
@SpringBootTest
class AdmireVOMapperTest {
    @Autowired
    private AdmireMapper admireMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    /**
     * 多数据源，可查询，可更新
     */
    @Test
    void select() {
        List<StudentDO> all = studentMapper.getAll();
        StudentDO student = all.stream().findFirst().get();
        student.setAge(19);
        int updateStudentByUserId = studentMapper.updateStudentByUserId(student);
        // 1
        System.out.println(updateStudentByUserId);

        AdmireDO admireVO = admireMapper.selectByPrimaryKey(1);
        admireVO.setTel("13384759669");
        int updateByPrimaryKey = admireMapper.updateByPrimaryKey(admireVO);
        // 1
        System.out.println(updateByPrimaryKey);

        List<TeacherDO> teachers = teacherMapper.getAll();
        System.out.println(Objects.requireNonNull(teachers.stream().findAny().orElse(null)).toString());

    }

    /**
     * 测试自定义多数据源mybatis全局变量
     */
    @Test
    void testMybatisProperty() {
        String activeProfile = ProfileUtil.getActiveProfile();
        List<StudentDO> webStudents = teacherMapper.getWebStudent();
        System.out.println(Objects.requireNonNull(webStudents.stream().findAny().orElse(null)).toString());

    }

}