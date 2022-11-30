package com.cashcall.merchant.MerchantService;

import com.cashcall.merchant.Controller.Merchant;
import com.cashcall.merchant.Repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service // tell the compiler this is a service class
//@Component
public class MerchantService {

    // final keyword ==> means the entity can be assigned once. it is a constant value

    private final MerchantRepository merchantRepository;

    @Autowired // allow dependency injection
    public MerchantService(MerchantRepository merchantRepository) {
        this.merchantRepository = merchantRepository;
    }

    public List<Merchant> getMerchant() {
        return merchantRepository.findAll();

        /*
        return List.of(
                new com.cashcall.merchant.Controller.Merchant(5L, "Ahmed", "e@e.com", LocalDate.of(2000, 3, 6), 23),
                new com.cashcall.merchant.Controller.Merchant(8L, "Saad", "d@e.com", LocalDate.of(2022, 4, 6), 26)
        );
        */
    }

}



/*
 * -------------------- *
 *
 * spring data jpa p
 *
 *
 *
 * */