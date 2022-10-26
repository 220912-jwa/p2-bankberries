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
            String sql = "select transaction_id ,transaction_description ,amount,account_number, checking_balance from checking_transactions ct left join  \n" +
                    "checking_account ca on  (ct.checking_account_id= ca.account_number) ";
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


    public CheckingTransactions createTransaction(CheckingTransactions checkingTransactions){
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "insert into project2.checking_transactions values(default, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, checkingTransactions.getTransDescription());
            ps.setDouble(2,checkingTransactions.getCkTransAmount());
            ps.setInt(3,checkingTransactions.getCheckingAccountId());
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                rs.getInt(checkingTransactions.getCkingTransId());
                return checkingTransactions;
            }


        }catch(SQLException e){
            e.printStackTrace();
        }return null;
    }
}
