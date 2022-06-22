package com.brody.eventSourcing.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.brody.eventSourcing.dto.StockDTO;
import com.brody.eventSourcing.entity.Stock;
import com.brody.eventSourcing.mapping.Mappers;
import com.brody.eventSourcing.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {
	
	private StockRepository stockRepository;
	
	private Mappers mappers;
	
	
	public StockServiceImpl(StockRepository stockRepository,  Mappers mappers) {
		this.stockRepository = stockRepository;
		this.mappers = mappers;
	}

	@Override
	public StockDTO addStock(StockDTO stockDTO) {
		
		Stock stock = mappers.fromStockDTO(stockDTO);
		
		List<Stock> existingStockList = stockRepository.findByName(stock.getName());
		 
	    if (existingStockList != null && !existingStockList.isEmpty()) {
	 
	        Stock existingStock = existingStockList.get(0);
	 
	        int newQuantity = existingStock.getQuantity() + stock.getQuantity();
	 
	        existingStock.setQuantity(newQuantity);
	        existingStock.setAddedBy(stock.getAddedBy());
	        Stock savedStock = stockRepository.save(existingStock);
	        return mappers.fromStock(savedStock);
	 
	    } else {
	 
	    	Stock savedStock = stockRepository.save(stock);
	    	return mappers.fromStock(savedStock);
	    }
	}

	@Override
	public List<StockDTO> getStocks() {
			
		List<Stock> stocks = stockRepository.findAll();
		return mappers.fromListOfStock(stocks);
	}

	@Override
	public StockDTO getStock(Long id) {
		
		Stock stock = stockRepository.findById(id).orElse(null);
		return mappers.fromStock(stock);
	}

	@Override
	public StockDTO updateStock(StockDTO stockDTO) {
		Stock stock = mappers.fromStockDTO(stockDTO);
		Stock updatedStock = stockRepository.save(stock);
		return mappers.fromStock(updatedStock);
	}

	@Override
	public void deleteStock(StockDTO stockDTO) {
	
		Stock stock =  mappers.fromStockDTO(stockDTO);
		int newQuantity = 0;
		 
	    List<Stock> existingStockList = stockRepository.findByName(stock.getName());
	 
	    if (existingStockList != null && !existingStockList.isEmpty()) {
	 
	        Stock existingStock = existingStockList.get(0);
	 
	        newQuantity = existingStock.getQuantity() - stock.getQuantity();
	 
	        if (newQuantity <= 0) {
	             
	 
	        	stockRepository.delete(existingStock);
	        } else {
	            existingStock.setQuantity(newQuantity);
	            existingStock.setAddedBy(stock.getAddedBy());
	            stockRepository.save(existingStock);
	        }
	    }
	}

	@Override
	public void deleteStocks() {
		stockRepository.deleteAll();
	}

	@Override
	public List<StockDTO> getStocksByName(String name) {
		
		List<Stock> stocks = stockRepository.findByName(name);
		return mappers.fromListOfStock(stocks);
	}

}
