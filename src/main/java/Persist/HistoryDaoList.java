package Persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Exceptions.MailExists;
import Exceptions.UsernameExists;
import Model.History;

public class HistoryDaoList implements HistoryDaoInterface {

	protected final Map<String, String> queries;
	protected final DbConnect dbConnect;
	private final String TABLE_NAME;

	private HistoryDaoList() throws ClassNotFoundException{
        this.TABLE_NAME = "historial";
        this.dbConnect = DbConnect.getInstance();
        this.queries = new HashMap<>();
        initQueries();
    }

	private History fromResultSet(ResultSet rs) throws SQLException {
		History h = null;
		String mail = rs.getString("idrestaurante");
		int id_Restaurant = rs.getInt("idrestaurante");
		Boolean fav = rs.getBoolean("favorito");

		h = new History(mail, id_Restaurant, fav);
		return h;
	}

	@Override
	public void insert(History h) throws SQLException{
		int result = 0;
		try {
            //get a connection to database.
            Connection conn = dbConnect.getConnection();
            if (conn != null) {
                PreparedStatement st = conn.prepareStatement(queries.get("insert"));
                st.setString(1, h.getMail());
                st.setInt(2, h.getId_Restaurant());
                st.setBoolean(3, h.isFav());
                result = st.executeUpdate();
                //close resources.
                st.close();
                conn.close();
            }
        } catch (SQLException ex) {
            //Logger.getLogger(ShowCountriesJdbcMySql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex.getMessage());
        }

	}

	@Override
	public List<History> selectAll(String mail) {
		List<History> result = new ArrayList<>();
        try {
            Connection conn = dbConnect.getConnection();
            if (conn != null) {
                String query = queries.get("sAll");
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, mail);
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    History obj = fromResultSet(rs);
                    if (obj != null) {
                        result.add(obj);
                    }
                }
            }

        } catch (SQLException ex) {
            //Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            result = null;
        }
        return result;
	}

	@Override
	public List<History> selectWhereFav(String mail) {
		List<History> result = new ArrayList<>();
        try {
            Connection conn = dbConnect.getConnection();
            if (conn != null) {
                String query = queries.get("sWhereFav");
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, mail);
                ResultSet rs = st.executeQuery(query);
                while (rs.next()) {
                    History obj = fromResultSet(rs);
                    if (obj != null) {
                        result.add(obj);
                    }
                }
            }

        } catch (SQLException ex) {
            //Logger.getLogger(ProductDao.class.getName()).log(Level.SEVERE, null, ex);
            result = null;
        }
        return result;
	}
	
	/**
     * initiatizes queries to database.
     */
    private void initQueries() {
    	
        queries.put("insert", String.format("insert into %s values (?, ?, ?)", TABLE_NAME));
        queries.put("sAll", String.format("select idrestaurante from user u, %s where %s.correo = ?", TABLE_NAME));
        queries.put("sWhereFav", String.format("select h.favorito from user u, %s where %s.correo = ?", TABLE_NAME));
    }
	
}
