package com.brody.eventSourcing.mapping;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.brody.eventSourcing.dto.StockDTO;
import com.brody.eventSourcing.entity.Stock;

@Service
public class MappersImpl implements Mappers {

	@Override
	public StockDTO fromStock(Stock stock) {
		
		StockDTO stockDTO = new StockDTO(stock.getName(), stock.getQuantity(), stock.getAddedBy());
		stockDTO.setId(stock.getId());
		return stockDTO;
	}

	@Override
	public Stock fromStockDTO(StockDTO stockDTO) {
		
		Stock stock = new Stock(stockDTO.getName(), stockDTO.getQuantity(), stockDTO.getAddedBy());
		stock.setId(stock.getId());
		return stock;
	}

	@Override
	public List<StockDTO> fromListOfStock(List<Stock> stocks) {
		
		return stocks.stream()
				.map(this::fromStock)
				.collect(Collectors.toList());
	}

	@Override
	public List<Stock> fromListOfStockDTO(List<StockDTO> stockDTOs) {
		
		return stockDTOs.stream()
				.map(this::fromStockDTO)
				.collect(Collectors.toList());
	}

}
