package com.diy.sigmund.springbootmultipledatasources.mapper.deploy;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.diy.sigmund.springbootmultipledatasources.entity.StudentDO;
import com.diy.sigmund.springbootmultipledatasources.entity.TeacherDO;

/**
 * @author ylm-sigmund
 * @since 2020/8/9 10:41
 */
@Mapper
@Repository
public interface TeacherMapper {
    List<TeacherDO> getAll();

    int updateTeacherDOByUserId(TeacherDO teacherDO);

    List<StudentDO> getWebStudent();

}
