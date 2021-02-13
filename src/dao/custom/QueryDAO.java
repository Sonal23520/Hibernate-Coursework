package dao.custom;

import dao.SuperDAO;
import entity.Course;

import java.util.ArrayList;

public interface QueryDAO extends SuperDAO {
    public Course getLastCourse()throws Exception;
}
