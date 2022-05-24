package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.Dealer;
import com.bnta.manual_trader.models.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealerRepository extends JpaRepository<Dealer, Long> {

    List<Dealer> findDealerByDealership(Dealership dealership);

    List<Dealer> getAllDealersByDealership(Dealership dealership);

    List<Dealer> findDealerByName(String name);

    List<Dealer> getAllDealersByName(String name);
}
