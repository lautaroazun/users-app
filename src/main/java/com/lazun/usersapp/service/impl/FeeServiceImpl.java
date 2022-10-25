package com.lazun.usersapp.service.impl;

import com.lazun.usersapp.models.dto.AmountDTO;
import com.lazun.usersapp.rest.user_fee.UserFeeRateRestClient;
import com.lazun.usersapp.service.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeeServiceImpl implements FeeService {

  @Autowired private UserFeeRateRestClient userFeeRateRestClient;

  @Override
  public AmountDTO sumWithFee(Integer firstNumber, Integer secNumber, Boolean mockError) {
    Float fee = userFeeRateRestClient.getUserFee(mockError);
    Float newAmount = (firstNumber + secNumber) * (1 + fee);
    AmountDTO amountDTO = new AmountDTO();
    amountDTO.setAmount(newAmount);
    return amountDTO;
  }
}