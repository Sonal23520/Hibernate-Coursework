package bo.custom.impl;

import bo.custom.LoginBo;
import dao.CrudDAO;
import dao.DaoFactory;
import dao.SuperDAO;
import dto.LoginDto;
import entity.Login;

import java.util.ArrayList;

public class LoginBoImpl implements LoginBo {
    CrudDAO dao = DaoFactory.getInstance().getDao(DaoFactory.DaoType.LOGIN);

    @Override
    public boolean save(LoginDto loginDto) throws Exception {
        return dao.save(new Login(loginDto.getId(),loginDto.getUsername(),loginDto.getPassword(),loginDto.getStatus()));

    }

    @Override
    public ArrayList<LoginDto> getAll() throws Exception {
        ArrayList<LoginDto> logindto = new ArrayList<>();
        ArrayList <Login>all = dao.getAll();
        for (Login login : all) {
            logindto.add(new LoginDto(login.getId(),login.getUsername(),login.getPassword(),login.getStatus()));
        }
        return logindto;
    }
}
