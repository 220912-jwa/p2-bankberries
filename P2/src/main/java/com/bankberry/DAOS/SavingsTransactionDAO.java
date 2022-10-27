package com.bankberry.DAOS;

import com.bankberry.entities.CheckingTransactions;
import com.bankberry.entities.SavingsTransactions;
import com.bankberry.utils.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SavingsTransactionDAO {


    public List<SavingsTransactions> getById(int id){
            List<SavingsTransactions> st = new ArrayList<>();
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "select transaction_id ,transaction_description ,amount,savings_account_number, savings_balance from project2.savings_transactions st left join  \n" +
                    "project2.savings_account sa  on  (st.savings_account_id = sa.savings_account_number) where account_number = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                st.add(new SavingsTransactions(
                        rs.getInt("transaction_id"),
                        rs.getString("transaction_description"),
                        rs.getDouble("amount"),
                        rs.getInt("savings_account_id")
                ));

            }return st;


        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public SavingsTransactions createTransaction(SavingsTransactions savingsTransactions){
        try(Connection connection = ConnectionUtil.createConnection()){
            String sql = "insert into project2.savings_transactions values(default, ?, ?, ?)";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, savingsTransactions.getSavingsTransDescription());
            ps.setDouble(2,savingsTransactions.getSavingsTransAmount());
            ps.setInt(3,savingsTransactions.getSavingsAccountId());

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                rs.getInt(savingsTransactions.getSavingsTransId());


                return savingsTransactions;
            }





        }catch(SQLException e){
            e.printStackTrace();
        }return null;
    }


}
