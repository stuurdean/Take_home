package com.Takehome.Services;

import com.Takehome.Controller.ControllerConstants;
import com.Takehome.Model.WithdrawalEvent;
import com.Takehome.Repository.BankAccountRepository;
import com.Takehome.Request.AccountRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class BankAccountService {

    @Autowired
    private BankAccountRepository accountRepository;
    @Autowired
    private  NotificationService notificationService;

    @Transactional
    public ResponseEntity<String> withdraw(AccountRequest request){
        try {

            if (accountRepository.getBalance(request.getAccountId()).compareTo(request.getAmount())<0){

                return ResponseEntity.ok(ControllerConstants.INSUFFICIENT_FUNDS);

            } else if (accountRepository.UpdateAccount(request)>0) {

                notificationService.publishWithdrawalEvent(new WithdrawalEvent(request.getAmount(),request.getAccountId(),"SUCCESSFUL"));
                return  ResponseEntity.ok(ControllerConstants.WITHDRAWAL_SUCCESS);
            }
            else {
                return ResponseEntity.ok(ControllerConstants.WITHDRAWAL_FAILED);
            }

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

}
