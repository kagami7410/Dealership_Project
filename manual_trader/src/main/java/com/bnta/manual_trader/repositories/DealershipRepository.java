package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealershipRepository extends JpaRepository<Dealership, Long> {
}
