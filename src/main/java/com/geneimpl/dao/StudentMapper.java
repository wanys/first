package com.geneimpl.dao;

import com.geneimpl.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Component("StudentMapper")
public interface StudentMapper {
    int deleteByPrimaryKey(Integer stuid);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Integer stuid);
    public List<Student> getStuByName(@Param("stuname") String stuname);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);
}