/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import wrappers.Authenticate;
import wrappers.Security;
import wrappers.User;

/**
 *
 * @author Anirudh
 */
public class UserManager {

    private final Security AES;
    private final JdbcTemplate TEMP;
    private final String SELECT_ALL;
    private final String DELETE;
    private final String GET;
    private final String INSERT;
    private final String UPDATE;
    private final String UPDATE_PASSWORD;
    private final String AUTHENTICATE;
    private final String SELECT_ADMIN;
    private final String SELECT_USERS;

    public UserManager(DataSource dataSource) {
        TEMP = new JdbcTemplate(dataSource);
        
        SELECT_ALL = "SELECT * FROM USERS";
        DELETE = "DELETE FROM USERS WHERE USERNAME = ?";
        GET = "SELECT * FROM USERS WHERE USERNAME =";
        INSERT = "INSERT INTO USERS(USERNAME, FIRSTNAME, LASTNAME, PASSWORD, PHONE, TYPE) VALUES (?,?,?,?,?,?)";
        UPDATE = "UPDATE USERS SET FIRSTNAME=? ,LASTNAME=?,PHONE=?,TYPE=? WHERE USERNAME=?";
        UPDATE_PASSWORD = "UPDATE USERS SET PASSWORD=? WHERE USERNAME=?";
        AUTHENTICATE = "SELECT * FROM USERS WHERE USERNAME='%s' AND PASSWORD='%s'";
        SELECT_ADMIN = "SELECT * FROM USERS WHERE TYPE=1";
        SELECT_USERS = "SELECT * FROM USERS WHERE TYPE=0";
        AES = new Security();
    }

    public List<User> list() {
        List<User> list = TEMP.query(this.SELECT_ALL, new RowMapper<User>() {
            @Override
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User u = new User();
                u.setAdmin(rs.getBoolean("TYPE"));
                u.setFirstName(rs.getString("FIRSTNAME"));
                u.setLastName(rs.getString("LASTNAME"));
                u.setPassword(rs.getString("PASSWORD"));
                u.setPhone(rs.getString("PHONE"));
                u.setUsername(rs.getString("USERNAME"));
                return u;
            }
        });
        return list;
    }

    public boolean authenticate(Authenticate auth) {
        if (auth.username.equalsIgnoreCase("")
                || auth.username.equalsIgnoreCase(null)
                || auth.password.equalsIgnoreCase("")
                || auth.password.equalsIgnoreCase(null)) {
            return false;
        } else {
            try {
                String query = String.format(this.AUTHENTICATE, auth.username.toUpperCase(), AES.encrypt(auth.password));
                return TEMP.query(query, (ResultSet rs) -> {
                    if (rs.next()) {
                        User r = new User();
                        r.setAdmin(rs.getBoolean("TYPE"));
                        r.setFirstName(rs.getString("FIRSTNAME"));
                        r.setLastName(rs.getString("LASTNAME"));
                        r.setPassword(rs.getString("PASSWORD"));
                        r.setPhone(rs.getString("PHONE"));
                        r.setUsername(rs.getString("USERNAME"));
                        return r;
                    }
                    return null;
                }) != null;
            } catch (Exception ex) {
                return false;
            }
        }
    }
    
    public List<User> listUser(boolean isAdmin) {
        if (isAdmin) {
            List<User> list = TEMP.query(this.SELECT_ADMIN, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User u = new User();
                    u.setAdmin(rs.getBoolean("TYPE"));
                    u.setFirstName(rs.getString("FIRSTNAME"));
                    u.setLastName(rs.getString("LASTNAME"));
                    u.setPassword(rs.getString("PASSWORD"));
                    u.setPhone(rs.getString("PHONE"));
                    u.setUsername(rs.getString("USERNAME"));
                    return u;
                }
            });
            return list;
        } else {
            List<User> list = TEMP.query(this.SELECT_USERS, new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User u = new User();
                    u.setAdmin(rs.getBoolean("TYPE"));
                    u.setFirstName(rs.getString("FIRSTNAME"));
                    u.setLastName(rs.getString("LASTNAME"));
                    u.setPassword(rs.getString("PASSWORD"));
                    u.setPhone(rs.getString("PHONE"));
                    u.setUsername(rs.getString("USERNAME"));
                    return u;
                }
            });
            return list;
        }
    }

    public Boolean delete(String username) {
        try {
            return TEMP.update(this.DELETE, username.toUpperCase()) == 1;
        } catch (DataAccessException ex) {
            return false;
        }
    }

    public User get(String username) {
        String query = this.GET + "\'" + username.toUpperCase() + "\'";
        return TEMP.query(query, (ResultSet rs) -> {
            if (rs.next()) {
                User r = new User();
                r.setAdmin(rs.getBoolean("TYPE"));
                r.setFirstName(rs.getString("FIRSTNAME"));
                r.setLastName(rs.getString("LASTNAME"));
                r.setPassword(rs.getString("PASSWORD"));
                r.setPhone(rs.getString("PHONE"));
                r.setUsername(rs.getString("USERNAME"));
                return r;
            }
            return null;
        });
    }

    public boolean authenticate(String username, String password) {
        if (username.equalsIgnoreCase("")
                || username.equalsIgnoreCase(null)
                || password.equalsIgnoreCase("")
                || password.equalsIgnoreCase(null)) {
            return false;
        } else {
            try {
                String query = String.format(this.AUTHENTICATE, username.toUpperCase(), AES.encrypt(password));
                return TEMP.query(query, (ResultSet rs) -> {
                    if (rs.next()) {
                        User r = new User();
                        r.setAdmin(rs.getBoolean("TYPE"));
                        r.setFirstName(rs.getString("FIRSTNAME"));
                        r.setLastName(rs.getString("LASTNAME"));
                        r.setPassword(rs.getString("PASSWORD"));
                        r.setPhone(rs.getString("PHONE"));
                        r.setUsername(rs.getString("USERNAME"));
                        return r;
                    }
                    return null;
                }) != null;
            } catch (Exception ex) {
                return false;
            }
        }
    }

    public boolean add(Object object) {
        if (object instanceof User) {
            User i = (User) object;
            if (this.get(i.getUsername()) == null) {
                try {
                    return TEMP.update(this.INSERT,
                            i.getUsername().toUpperCase(), i.getFirstName().toUpperCase(), i.getLastName().toUpperCase(), AES.encrypt(i.getPassword()), i.getPhone(), i.isAdmin()) == 1;
                } catch (Exception ex) {
                    // ecryption failed
                    return false;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean update(Object object) {
        if (object instanceof User) {
            User i = (User) object;
            if (this.get(i.getUsername().toUpperCase()) == null) {
                return false;
            } else {
                return TEMP.update(this.UPDATE,
                        i.getFirstName().toUpperCase(), i.getLastName().toUpperCase(), i.getPhone(), i.isAdmin(), i.getUsername().toUpperCase()) == 1;
            }
        } else {
            return false;
        }
    }

    public boolean updatePassword(String username, String oldPassword, String newPassword) {
        User oldUser = this.get(username.toUpperCase());
        if (oldUser == null) {
            return false;
        } else {
            if (oldUser.getPassword().equalsIgnoreCase(oldPassword)) {
                try {
                    return TEMP.update(this.UPDATE_PASSWORD, AES.encrypt(newPassword), username.toUpperCase()) == 1;
                } catch (Exception ex) {
                    System.out.println(ex);
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public boolean updatePassword(String username, String newPassword) {
        User oldUser = this.get(username.toUpperCase());
        if (oldUser == null) {
            return false;
        } else {
            try {
                return TEMP.update(this.UPDATE_PASSWORD, AES.encrypt(newPassword), username.toUpperCase()) == 1;
            } catch (Exception ex) {
                System.out.println(ex);
                return false;
            }
        }
    }

    public Boolean userExists(String username) {
        return this.get(username) != null;
    }

}
