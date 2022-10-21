package com.bankberry.DAOS;

import com.bankberry.entities.CheckingTransactions;

import com.bankberry.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckingTransactionsDAO {



    public CheckingTransactions getById(int id){

        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "select * from project2.checking_transactions where transaction_id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                return new CheckingTransactions(
                        rs.getInt("transaction_id"),
                        rs.getString("transaction_description"),
                        rs.getDouble("amount"),
                        rs.getInt("checking_account_id")
                );
            }


        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }


    public void createTransaction(String descript, double amount, int checking_id){
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "insert into project2.checking_transactions values(default, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, descript);
            ps.setDouble(2,amount);
            ps.setInt(3,checking_id);
            ps.execute();



        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
