package com.cashcall.merchant.Controller;

import com.cashcall.merchant.MerchantService.MerchantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// allow this class to serve endpoints

@RestController
@RequestMapping(path = "api/v1/merchant")
public class MerchantController {

    @Autowired // that allow dependency injection
    private final MerchantService merchantService;

    public MerchantController(MerchantService merchantService) {
        this.merchantService = merchantService;
    }

    @GetMapping("list")
    public List<com.cashcall.merchant.Controller.Merchant> getMerchant() {
        return merchantService.getMerchant();
    }
}


/**
 *
 */