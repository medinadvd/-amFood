package Persist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import Exceptions.UsernameExists;
import Exceptions.MailExists;
import Exceptions.UserExists;
import Model.Preference;
import Model.Restaurant;
import Model.User;

public class UserDaoList implements UserDaoInterface {
    protected final Map<String, String> queries;
    protected final DbConnect dbConnect;
    private final String TABLE_NAME;
    
    private UserDaoList() throws MailExists, UsernameExists, ClassNotFoundException{
        this.TABLE_NAME = "user";
        this.dbConnect = DbConnect.getInstance();
        this.queries = new HashMap<>();
        initQueries();
    }
    
    /**
     * converts resultset entry to entity object.
     *
     * @param rs resultset to get data from.
     * @return object with data in current position of resultset.
     */
    private User fromResultSet(ResultSet rs) throws SQLException {
        User u = null;
        String mail = rs.getString("correo");
        String username = rs.getString("nombre");
        String password = rs.getString("contraseña");
        int id_Restaurant = rs.getInt("idrestaurante");
        //Preferences pref = rs.get
		
        u = new User(mail, username, password, id_Restaurant);
        return u;
    }
    
	private Preference fromResultSetP(ResultSet rs) throws SQLException {
        Preference p = null;
        String id = rs.getString("id");
        Boolean vegan = rs.getBoolean("vegano");
        Boolean vege = rs.getBoolean("vegetariano");
        Boolean halal = rs.getBoolean("halal");
        Boolean glutenfree = rs.getBoolean("gluten_free");
		
        p = new Preference(id, vegan, vege, halal, glutenfree);
        return p;
    }
    
    private Restaurant fromResultSetR(ResultSet rs) throws SQLException {
        Restaurant r = null;
        int id_Restaurant = rs.getInt("id_Restaurant");
        int tier = rs.getInt("tier");
        String type = rs.getString("mail");
        String name = rs.getString("username");
        String gps = rs.getString("password");
        int score = rs.getInt("score");
        int movil = rs.getInt("movil");
        //Preferences pref = rs.get
		
        r = new Restaurant(id_Restaurant, null, tier, type, name, gps, score, movil);
        return r;
    }
    

    @Override
    public int insert(User entity) throws MailExists, UsernameExists, UserExists, SQLException{
    	int result = 0;
    	User result1 = selectWhere(entity.getUsername(), "sWhereUsername");
        User result2 = selectWhere(entity.getMail(), "sWhereMail");
        if (result1 == null && result2 == null) {
        	try {
                //get a connection to database.
                Connection conn = dbConnect.getConnection();
                if (conn != null) {
                    PreparedStatement st = conn.prepareStatement(queries.get("insert"));
                    st.setString(1, entity.getMail());
                    st.setString(2, entity.getUsername());
                    st.setString(3, entity.getPassword());
                    result = st.executeUpdate();
                    //close resources.
                    st.close();
                    conn.close();
                }
            } catch (SQLException ex) {
                //Logger.getLogger(ShowCountriesJdbcMySql.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println(ex.getMessage());
            }
        } else if (result1 == null && result2 != null) {
            throw new UsernameExists("There is already a user with this Mail");
        } else if (result1 != null && result2 == null) {
            throw new MailExists("There is already a user with this Username");
        } else {
            throw new UserExists("There is already a user with this Mail and Username");
        }
        return result;
    }

    /*@Override
    public int update(User oldEntity, User newEntity) throws MailExists, UsernameExists, UserExists, SQLException{
        int rowsAffected;
        User result = selectWhere(oldEntity.getMail(), "sWhereMail");
        if (result != null) {
            newEntity.setMail(oldEntity.getMail());
            data.remove(oldEntity);
            User result1 = selectWhere(newEntity.getUsername(), "sWhereUsername");
            User result2 = selectWhere(newEntity.getMail(), "sWhereMail");
            if (result1 == null && result2 == null) {
                rowsAffected = 1;
                data.add(newEntity);
            } else if (result1 == null && result2 != null) {
                throw new UsernameExists("There is already a user with this Mail");
            } else if (result1 != null && result2 == null) {
                throw new MailExists("There is already a user with this username");
            } else {
                throw new UserExists("There is already a user with this Mail and Username");
            }
        } else {
            rowsAffected = 0;
        }

        return rowsAffected;
    }*/

	@Override
	public User selectWhere(String code, String q) throws SQLException {
		User result = null;
		try {
            Connection conn = dbConnect.getConnection();
            if (conn != null) {
                String query = queries.get(q);
                PreparedStatement st = conn.prepareStatement(query);
                st.setString(1, code);
                ResultSet rs = st.executeQuery();
                while (rs.next()) {
                    User obj = fromResultSet(rs);
                    if (obj != null) {
                        result = obj;
                    }
                }
            }
        } catch (SQLException ex) {
            result = null;
        }
        return result;
	}
	
	
	
	/**
     * initiatizes queries to database.
     */
    private void initQueries() {
    	
        queries.put("insert", String.format("insert into %s values (?, ?, ?, null)", TABLE_NAME));
        //queries.put("modify", String.format("update %s set capacity = ?, date = ?, time = ? where code = ?", TABLE_NAME));
        
        queries.put("sWhereMail", String.format("select * from %s where mail = ?", TABLE_NAME));
        queries.put("sWhereUsername", String.format("select * from %s where username = ?", TABLE_NAME));
    }

}
