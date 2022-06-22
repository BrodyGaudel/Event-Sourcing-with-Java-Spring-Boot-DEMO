package com.brody.eventSourcing.service;

import java.util.List;

import com.brody.eventSourcing.dto.StockDTO;

public interface StockService {
	
	StockDTO addStock(StockDTO stockDTO);
	
	List<StockDTO> getStocks();
	
	StockDTO getStock(Long id);
	
	StockDTO updateStock(StockDTO stockDTO);
	
	void deleteStock(StockDTO stockDTO);
	
	void deleteStocks();
	
	List<StockDTO> getStocksByName(String name);

}
