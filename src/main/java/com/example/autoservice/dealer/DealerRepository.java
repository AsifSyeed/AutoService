package com.example.autoservice.dealer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DealerRepository extends JpaRepository<Dealer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.id = ?1")
    Optional<Dealer> findDealerById (Long id);
}
