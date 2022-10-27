package com.bankberry.DAOS;

import com.bankberry.entities.CheckingTransactions;

import com.bankberry.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CheckingTransactionsDAO {



    public List<CheckingTransactions> getById(int id){
            List<CheckingTransactions> ct = new ArrayList<>();
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "select transaction_id ,transaction_description ,amount,account_number, checking_balance from project2.checking_transactions ct left join  \n" +
                    "project2.checking_account ca on  (ct.checking_account_id= ca.account_number) where account_number =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            System.out.println(rs);
            while(rs.next()){
                ct.add( new CheckingTransactions(
                        rs.getInt("transaction_id"),
                        rs.getString("transaction_description"),
                        rs.getDouble("amount"),
                        rs.getInt("account_number")


                ));
                System.out.println(ct);

            }return ct;


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
