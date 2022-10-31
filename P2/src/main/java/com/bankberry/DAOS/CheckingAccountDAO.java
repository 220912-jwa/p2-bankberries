package com.bankberry.DAOS;

import com.bankberry.entities.CheckingAccount;
import com.bankberry.entities.CheckingTransactions;
import com.bankberry.utils.ConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CheckingAccountDAO {

    public CheckingAccount getByAccountNumber(int checkID) {
        try (Connection connection = ConnectionUtil.createConnection()) {
            String sql = "select * from project2.checking_account where account_number =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, checkID);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new CheckingAccount(
                        rs.getInt("account_number"),
                        rs.getDouble("checking_balance")

                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void updateChecking(int id, double amount) {
        try (Connection connection = ConnectionUtil.createConnection()) {
            String sql = "update project2.checking_account set checking_balance =? where account_number =?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setDouble(1, amount);
            ps.setInt(2, id);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
