package com.Takehome.Controller;

import com.Takehome.Request.AccountRequest;
import com.Takehome.Services.BankAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;


@RestController
@RequestMapping(ControllerConstants.BANK)
@Validated
public class BankAccountController {

    @Autowired
    private BankAccountService accountService;


    @PostMapping(ControllerConstants.WITHDRAW)
    public ResponseEntity<String> withdraw(@Valid @RequestBody AccountRequest withdraw){

        return  accountService.withdraw(withdraw);
    }
    @PostMapping("/Deposit")
    public AccountRequest accountRequest(@RequestBody AccountRequest request){


        // or use logging
       // logger.info("Received withdraw request: {}", request);
        return  request;
    }
}
