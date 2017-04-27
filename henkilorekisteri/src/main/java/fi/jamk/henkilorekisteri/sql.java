package fi.jamk.henkilorekisteri;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:application.properties")
public class sql {

	public void update (String sukunimi, String henkilotunnus, String puhelinnumero, String sahkoposti,
			  			String tyosuhdealkanut, String tilinumero, String veronumero) {
		try {
			Connection mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/henkilorekisteri?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "root");
			
			mysqlConnection.setAutoCommit(false);
			
			String updateTableSQL = "UPDATE henkilot set sukunimi=?, puhelinnumero=?, sahkoposti=?, tyosuhdealkanut=?, tilinumero=?, veronumero=? WHERE henkilotunnus=?";

			PreparedStatement preparedStatementInsert = mysqlConnection.prepareStatement(updateTableSQL);
			
			preparedStatementInsert.setString(1, sukunimi);
			preparedStatementInsert.setString(2, puhelinnumero);
			preparedStatementInsert.setString(3, sahkoposti);
			preparedStatementInsert.setString(4, tyosuhdealkanut);
			preparedStatementInsert.setString(5, tilinumero);
			preparedStatementInsert.setString(6, veronumero);
			preparedStatementInsert.setString(7, henkilotunnus);
			preparedStatementInsert.executeUpdate();

			mysqlConnection.commit();
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	public void delete (String ssn) {
		try {
		Connection mysqlConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/henkilorekisteri?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false", "root", "root");
		
		mysqlConnection.setAutoCommit(false);
		
		String DeletePersonTableSQL = "DELETE FROM henkilot WHERE henkilotunnus=?";
		
		PreparedStatement preparedStatementInsert = mysqlConnection.prepareStatement(DeletePersonTableSQL);

		preparedStatementInsert.setString(1, ssn);
		preparedStatementInsert.executeUpdate();
		
		mysqlConnection.commit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		}
	}
