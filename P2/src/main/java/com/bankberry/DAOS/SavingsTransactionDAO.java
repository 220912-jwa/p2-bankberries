package com.bankberry.DAOS;

import com.bankberry.entities.CheckingTransactions;
import com.bankberry.entities.SavingsTransactions;
import com.bankberry.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SavingsTransactionDAO {


    public SavingsTransactions getById(int id){

        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "select * from project2.savings_transactions where transaction_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new SavingsTransactions(
                        rs.getInt("transaction_id"),
                        rs.getString("transaction_description"),
                        rs.getDouble("amount"),
                        rs.getInt("savings_account_id")
                );
            }


        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public void createTransaction(String descript, double amount, int savings_id){
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "insert into project2.savings_transactions values(default, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, descript);
            ps.setDouble(2,amount);
            ps.setInt(3,savings_id);

            ps.execute();



        }catch(SQLException e){
            e.printStackTrace();
        }
    }


}
