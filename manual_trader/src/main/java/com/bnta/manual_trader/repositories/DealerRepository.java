package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.Dealer;
import com.bnta.manual_trader.models.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealerRepository extends JpaRepository<Dealer, Long> {

    List<Dealer> findDealersByDealerships(Dealership dealership);
}
