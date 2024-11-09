package com.Takehome.Repository;

import com.Takehome.Request.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
@Repository
public class BankAccountRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

  public   BigDecimal getBalance(Long accountId){

        return  jdbcTemplate.queryForObject( "SELECT balance FROM accounts WHERE id = ?",new Object[]{accountId},BigDecimal.class);
    }
    public   int UpdateAccount(AccountRequest accountRequest){

        return  jdbcTemplate.update("UPDATE accounts SET balance = balance - ? WHERE id = ?",accountRequest.getAmount(),accountRequest.getAccountId());
    }
}
