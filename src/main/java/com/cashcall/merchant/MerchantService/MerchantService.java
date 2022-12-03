package com.cashcall.merchant.MerchantService;

import com.cashcall.merchant.Controller.Merchant;
import com.cashcall.merchant.MerchantApplication;
import com.cashcall.merchant.Repository.MerchantRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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

    public void addMerchant(Merchant merchant) {

        Optional<Merchant> merchantByEmail = merchantRepository.findMerchantByEmail(merchant.getEmail());

        // Check if the email is taken or not.
        if (merchantByEmail.isPresent()) {
            throw new IllegalStateException("Email is used before! Choose another one..");
        }

        merchantRepository.save(merchant); // Save user in db
    }

    public void deleteMerchant(Long merchantId) {
        // Optional<Merchant> merchant = merchantRepository.findById(merchantId);

        boolean isMerchantExists = merchantRepository.existsById(merchantId);

        if (!isMerchantExists) {
            throw new IllegalStateException(
                    "Merchant: " + merchantId + " is not exists! 😲"
            );
        }

        merchantRepository.deleteById(merchantId);
    }

    @Transactional // means you don't have to implement any jpql Query.
    public void updateMerchant(Long merchantId, Merchant merchantData, String name, String email) {

        Merchant merchant = merchantRepository.findById(merchantId)
                .orElseThrow(() -> new IllegalStateException("Merchant: " + merchantId + " is not exists! 😲"));

        if (email != null && email.length() > 0 &&
                !Objects.equals(merchant.getEmail(), email)) {
            Optional<Merchant> merchantOptional = merchantRepository.findMerchantByEmail(email);

            if (merchantOptional.isPresent()) {
                throw new IllegalStateException("This email is already exists! 😥🤷‍");
            }
            merchant.setEmail(email);
        }

        if (name != null && name.length() > 0 && !Objects.equals(merchant.getName(), name)) {
            merchant.setName(name);
        }
    }
}



/*
 * -------------------- *
 *
 * spring data jpa p
 *
 *
 *
 *
 *
 * */