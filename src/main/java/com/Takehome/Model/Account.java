package com.Takehome.Model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Setter
@Getter
public class Account {
    private Long Id;
    private BigDecimal balance;
    private Date startDate;
    private Date updateDate;
    private String status;
    private String type;
}
