package dao.custom;

import dao.SuperDAO;
import entity.Course;
import entity.Registration;
import entity.Student;

import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    public Course getLastCourse()throws Exception;
    public Student getLastStudent()throws Exception;
    public Registration getLastRegistration()throws Exception;
}
