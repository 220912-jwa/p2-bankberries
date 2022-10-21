package com.bankberry.DAOS;

import com.bankberry.entities.LoanApplication;
import com.bankberry.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoanAppDAO {


    public void createLoan(double amount, int term, int userId){
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "insert into porject2.loan_applications values(default, ?,?,? )";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1,amount);
            ps.setInt(2,term);
            ps.setInt(3,userId);
        }catch(SQLException e){
            e.printStackTrace();
        }


    }

    public List<LoanApplication> getAllUserLoans(int id){
        List<LoanApplication> loanList = new ArrayList<>();
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "Select * from project2.loan_applications where user_id=?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                LoanApplication loan = new LoanApplication(
                rs.getInt("app_id"),
                rs.getDouble("amount"),
                rs.getInt("term"),
                rs.getInt("user_id")
                );
                loanList.add(loan);

            }
            return loanList;
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}