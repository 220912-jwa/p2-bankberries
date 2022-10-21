package com.bankberry.DAOS;

import com.bankberry.entities.LoanApplication;
import com.bankberry.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
}
