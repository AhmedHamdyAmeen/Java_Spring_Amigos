package com.cashcall.merchant.Repository;

import com.cashcall.merchant.Model.Merchant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository // tel the compiler this class is a repository class and deals with the database
public interface MerchantRepository
        extends JpaRepository<Merchant, Long> { // <Type Of object, type of id>

    // Customize Some Queries
    // SELECT * FROM merchant WHERE email = ?
    @Query("SELECT m FROM Merchant m WHERE m.email = ?1") // that is a jpQL
    Optional<Merchant> findMerchantByEmail (String email);
}
