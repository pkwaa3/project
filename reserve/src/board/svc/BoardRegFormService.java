package board.svc;

import vo.Owner;
import vo.Restaurant;
import static db.JdbcUtil.*;

import java.sql.Connection;

import dao.OwnerDAO;
import dao.RestaurantDAO;
public class BoardRegFormService {

	

	public Owner getOwnerInfo(String id) {
		Owner owner =null;
		Connection con = null;
		
		try {
			con = getConnection();
			OwnerDAO ownerDAO = OwnerDAO.getInstance();
			ownerDAO.setConnection(con);
			owner = ownerDAO.selectModOwner(id);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return owner;
	}

	public Restaurant getRestInfo(int owner_no) {
		Restaurant rest  =null;
		Connection con = null;
		
		try {
			con = getConnection();
			RestaurantDAO restDAO = RestaurantDAO.getInstance();
			restDAO.setConnection(con);
			rest = restDAO.RestInfo(owner_no);
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(con);
		}
		return rest;
	}

}
