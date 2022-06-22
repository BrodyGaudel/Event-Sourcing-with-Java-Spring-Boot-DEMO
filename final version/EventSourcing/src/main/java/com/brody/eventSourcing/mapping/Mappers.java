package com.brody.eventSourcing.mapping;

import java.util.List;

import com.brody.eventSourcing.dto.StockDTO;
import com.brody.eventSourcing.entity.Stock;

/**
 * 
 * @author brody
 *
 */
public interface Mappers {
	
	StockDTO fromStock(Stock stock);
	
	Stock fromStockDTO(StockDTO stockDTO);
	
	List<StockDTO> fromListOfStock(List<Stock> stocks);
	
	List<Stock> fromListOfStockDTO(List<StockDTO> stockDTO);

}
