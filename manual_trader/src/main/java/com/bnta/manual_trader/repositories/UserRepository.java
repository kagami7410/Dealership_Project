package com.bnta.manual_trader.repositories;

import com.bnta.manual_trader.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
