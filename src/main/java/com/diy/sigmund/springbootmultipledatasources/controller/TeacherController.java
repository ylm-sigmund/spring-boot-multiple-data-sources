package com.diy.sigmund.springbootmultipledatasources.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diy.sigmund.springbootmultipledatasources.entity.StudentDO;
import com.diy.sigmund.springbootmultipledatasources.entity.TeacherDO;
import com.diy.sigmund.springbootmultipledatasources.service.TeacherService;

/**
 * @author ylm-sigmund
 * @since 2020/8/23 20:44
 */
@Controller
@RestController
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("getAll")
    public List<TeacherDO> getAll() {
        return teacherService.getAll();
    }

    @RequestMapping("getWebStudent")
    public List<StudentDO> getWebStudent() {
        return teacherService.getWebStudent();
    }

}
