package bo.custom;

import bo.SuperBO;
import dto.CourseDto;
import dto.RegistrationDto;

import java.util.ArrayList;

public interface RegistrationBo extends SuperBO {
    public boolean save(RegistrationDto registrationDto)throws Exception;
    public boolean update(RegistrationDto registrationDto)throws Exception;
    public boolean delete(String s)throws Exception;
    public RegistrationDto search(String s)throws Exception;
    public ArrayList<RegistrationDto> getAll()throws Exception;
    public RegistrationDto gernarateId() throws Exception;
}
