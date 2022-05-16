package com.tigran.supermarketamscrapper.repo;

import com.tigran.supermarketamscrapper.entity.Electronic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ElectronicRepository extends JpaRepository<Electronic, Integer> {
    @Query("from Electronic e where e.link=:link")
    Electronic findByLink(@Param("link") String link);

}
