package com.diy.sigmund.springbootmultipledatasources.mapper.web;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import com.diy.sigmund.springbootmultipledatasources.entity.StudentDO;
import org.springframework.stereotype.Repository;

/**
 * @author ylm-sigmund
 * @since 2020/8/9 10:41
 */
@Mapper
@Repository
public interface StudentMapper {
    List<StudentDO> getAll();

    int updateStudentByUserId(StudentDO student);
}
