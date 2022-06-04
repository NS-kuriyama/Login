package jp.co.aforce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jp.co.aforce.beans.Beans;

public class LoginDAO extends DAO {
	public Beans search(String login, String password) throws Exception{

		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement("select * from login where login=? and password=?");

			st.setString(1, login);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();

			Beans b = new Beans();

				while (rs.next()) {
					b.setLogin(rs.getString("login"));
					b.setPassword(rs.getString("password"));
				}
				st.close();
				con.close();

				return b;
	}
}

