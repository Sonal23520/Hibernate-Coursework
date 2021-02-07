package bo.custom;

import bo.SuperBO;
import dto.LoginDto;

import java.util.ArrayList;

public interface LoginBo extends SuperBO {
    public boolean save(LoginDto loginDto)throws Exception;
    public ArrayList<LoginDto>getAll()throws Exception;
}
