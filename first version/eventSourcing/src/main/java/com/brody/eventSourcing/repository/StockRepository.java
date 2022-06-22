package com.brody.eventSourcing.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.brody.eventSourcing.entity.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {
	
	List<Stock> findByName(String name);
}
