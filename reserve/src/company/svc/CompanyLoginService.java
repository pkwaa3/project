package company.svc;

import static db.JdbcUtil.close;
import static db.JdbcUtil.getConnection;

import java.sql.Connection;

import dao.CompanyDAO;

import vo.Company;

public class CompanyLoginService {

	public boolean login(Company company) {
		Connection con = getConnection();
		CompanyDAO companyDAO = CompanyDAO.getInstance();
		companyDAO.setConnection(con);
		
		boolean loginResult = false;
		
		String loginId=companyDAO.selectLoginId(company);
		if(loginId != null) {
			loginResult = true;
		}
		
		close(con);
		
		return loginResult;
	}

}
