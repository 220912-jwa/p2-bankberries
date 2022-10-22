package com.bankberry.DAOS;

import com.bankberry.entities.CheckingAccount;
import com.bankberry.entities.SavingsAccount;
import com.bankberry.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SavingsAccountDAO {

    public SavingsAccount getByAccountNumber(int savingsId){
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql ="select * from project2.savings_account where savings_account_number =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,savingsId);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new SavingsAccount(
                        rs.getInt("savings_account_number"),
                        rs.getDouble("savings_balance")

                );
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
    public void updateSavings(int id, double amount){
        try (Connection connection = ConnectionUtil.createConnection()){
            String sql = "update project2.savings_account set savings_balance =? where savings_account_number =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1,amount);
            ps.setInt(2, id);
            ps.execute();




        }catch (SQLException e){
            e.printStackTrace();
        }


    }
}
