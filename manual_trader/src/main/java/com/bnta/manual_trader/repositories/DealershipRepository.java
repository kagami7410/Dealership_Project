package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.Dealership;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DealershipRepository extends JpaRepository<Dealership, Long> {
    List<Dealership> findByNameContainingAndLocation(String name, String location);

    List<Dealership> findByNameContaining(String name);

    List<Dealership> findByLocation(String location);
}
