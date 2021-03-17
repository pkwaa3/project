package company.svc;

import java.sql.Connection;
import static db.JdbcUtil.*;
import dao.CompanyDAO;
import vo.Company;

public class CompanyJoinService {

	public boolean joinMember(Company company) {
		boolean joinSuccess = false;
		CompanyDAO companyDAO = CompanyDAO.getInstance();
		Connection con =getConnection();
		companyDAO.setConnection(con);
		
		int insert=companyDAO.insertCompany(company);
		
		if(insert>0) {
			joinSuccess = true;
			commit(con);
		} else {
			rollback(con);
		}
		
		close(con);
		
		return joinSuccess;
	}

}
