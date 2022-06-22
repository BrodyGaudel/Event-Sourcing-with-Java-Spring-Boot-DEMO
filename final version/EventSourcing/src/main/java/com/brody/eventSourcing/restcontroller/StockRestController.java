package com.brody.eventSourcing.restcontroller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.brody.eventSourcing.dto.StockDTO;
import com.brody.eventSourcing.service.StockService;

@RestController
@RequestMapping("/stock")
public class StockRestController {
	
	private StockService stockService;

	public StockRestController(StockService stockService) {
	
		this.stockService = stockService;
	}
	
	@PostMapping("/post/stock")
	@ResponseBody
	StockDTO addStock(@RequestBody StockDTO stockDTO) {
		return stockService.addStock(stockDTO);
	}
	
	@GetMapping("/get/stocks")
	@ResponseBody
	List<StockDTO> getStocks(){
		return stockService.getStocks();
	}
	
	@GetMapping("/get/stock/{id}")
	@ResponseBody
	StockDTO getStock(@PathVariable(name = "id") Long id) {
		return stockService.getStock(id);
	}
	
	@PutMapping("/put")
	@ResponseBody
	StockDTO updateStock(@RequestBody StockDTO stockDTO) {
		return stockService.updateStock(stockDTO);
	}

	@DeleteMapping("/delete/stock")
	void deleteStock(@RequestBody StockDTO stockDTO) {
		stockService.deleteStock(stockDTO);
	}
	
	@DeleteMapping("/delete/stocks")
	void deleteStocks() {
		stockService.deleteStocks();
	}
	
	@GetMapping("/get/stocks/list/{name}")
	@ResponseBody
	List<StockDTO> getStocksByName(@PathVariable(name = "name") String name){
		return stockService.getStocksByName(name);
	}

	
	

}
