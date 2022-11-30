package com.cashcall.merchant.Repository;

import com.cashcall.merchant.Controller.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository // tel the compiler this class is a repository class and deals with the database
public interface MerchantRepository
        extends JpaRepository<Merchant, Long> { // <Type Of object, type of id>

}
