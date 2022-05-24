package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {

    List<Purchase> getAllPurchasedCarsByDate(LocalDate date);
    List<Purchase> findByDate(LocalDate date);

}
