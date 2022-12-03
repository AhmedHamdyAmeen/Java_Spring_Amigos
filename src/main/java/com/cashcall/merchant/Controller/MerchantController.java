package com.cashcall.merchant.Controller;

import com.cashcall.merchant.MerchantService.MerchantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Merchant> getMerchant() {
        return merchantService.getMerchant();
    }

    @PostMapping("list")
    public void registerMerchant(
            @RequestBody Merchant merchant) {// take the req body and map it into the merchant method
        merchantService.addMerchant(merchant);
    }

    @DeleteMapping(path = "/list/{merchantId}")
    public void deleteMerchant(@PathVariable("merchantId") Long merchantId) {
        merchantService.deleteMerchant(merchantId);
    }

    @PutMapping("/list/{merchantId}")
    public void updateMerchant(
            @PathVariable("merchantId") Long merchantId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            Merchant merchantData) {
        merchantService.updateMerchant(merchantId, merchantData, name, email);
    }
}

/**
 *
 */