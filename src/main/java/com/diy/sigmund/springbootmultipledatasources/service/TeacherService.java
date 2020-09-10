package com.diy.sigmund.springbootmultipledatasources.service;

import com.diy.sigmund.springbootmultipledatasources.entity.StudentDO;
import com.diy.sigmund.springbootmultipledatasources.entity.TeacherDO;
import com.diy.sigmund.springbootmultipledatasources.mapper.deploy.TeacherMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ylm-sigmund
 * @since 2020/8/23 20:42
 */
@Service
public class TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;
    public List<TeacherDO> getAll(){
        return teacherMapper.getAll();
    }

    public List<StudentDO> getWebStudent(){
        return teacherMapper.getWebStudent();
    }

}
