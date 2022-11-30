package com.cashcall.merchant;

import com.cashcall.merchant.Controller.Merchant;
import com.cashcall.merchant.Repository.MerchantRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class MerchantConfig {

    @Bean
    CommandLineRunner commandLineRunner(MerchantRepository repository) {
        // to access the repository interface we need to inject it.

        // Adding Data to the Database.
        // Adding a Merchants to the merchant table.
        return args -> {
            Merchant saad = new Merchant(
                    "Saad",
                    "d@e.com",
                    LocalDate.of(2000, 4, 6));

            Merchant ahmed = new Merchant(
                    "Ahmed",
                    "a@e.com",
                    LocalDate.of(2005, 4, 6));

            repository.saveAll( // Save the List to the database
                    List.of(saad, ahmed)
            );
        };
    }
}


// Adding