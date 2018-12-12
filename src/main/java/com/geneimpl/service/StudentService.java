package com.geneimpl.service;

import com.geneimpl.model.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentService {
    public List<Student> getStuByName(@Param("stuname") String stuname);
    int insertSelective(Student record);
    Student selectByPrimaryKey(Integer stuid);
    int updateByPrimaryKeySelective(Student record);
}
