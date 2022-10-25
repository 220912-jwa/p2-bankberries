package com.bankberry.DAOS;

import com.bankberry.entities.User;
import com.bankberry.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {

    public User getByEmail(String email){
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "Select * from project2.users where email = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,email);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new User(
                        rs.getInt("access_number"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("pass"),
                        rs.getInt("check_id"),
                        rs.getInt("savings_id")

                );
            }



        }catch(SQLException e){
            e.printStackTrace();
        } return null;

    }
    public User getUserByAccessNumber(int accessNumber){

        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "Select * from project2.users where access_number = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,accessNumber);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new User(
                        rs.getInt("access_number"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("pass"),
                        rs.getInt("check_id"),
                        rs.getInt("savings_id")

                );
                }



        }catch(SQLException e){
            e.printStackTrace();
        } return null;

}

    public void updateEmail(String email, int accessNumber){
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql ="update project2.users set email =? where access_number = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,email);
            ps.setInt(2,accessNumber);
            ps.execute();
        }catch(SQLException e){
            e.printStackTrace();
        }

    }

    public void updatePass(String password, int accessNumber){
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "update project2.users set pass=? where access_number=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, password);
            ps.setInt(2, accessNumber);
            ps.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }




}
