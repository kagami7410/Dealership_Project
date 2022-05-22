package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.Dealer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealerRepository extends JpaRepository<Dealer, Long> {
}
