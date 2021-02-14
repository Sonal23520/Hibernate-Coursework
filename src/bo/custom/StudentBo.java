package bo.custom;

import bo.SuperBO;
import dto.CourseDto;
import dto.StudentDto;

import java.util.ArrayList;

public interface StudentBo extends SuperBO {
    public boolean save(StudentDto studentDto)throws Exception;
    public boolean update(StudentDto studentDto)throws Exception;
    public boolean delete(String s)throws Exception;
    public StudentDto search(String s)throws Exception;
    public ArrayList<StudentDto> getAll()throws Exception;
    public StudentDto gernarateId() throws Exception;
}
