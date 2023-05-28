package com.vitaliy.zhakun.smartphones.controller;

import com.vitaliy.zhakun.smartphones.model.Sale;
import com.vitaliy.zhakun.smartphones.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sales")
public class SaleController {

    private final SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @GetMapping("/make/{smartphoneId}/{managerId}/{customerId}/{quantity}")
    public ResponseEntity<Sale> makeSale(@PathVariable("smartphoneId") Long smartphoneId,
                                         @PathVariable("managerId") Long managerId,
                                         @PathVariable("customerId") Long customerId,
                                         @PathVariable("quantity") int quantity) {
        Sale commitedSale = saleService.createSale(smartphoneId, managerId, customerId, quantity);
        return new ResponseEntity<Sale>(commitedSale, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public List<Sale> getAllSales() {
        return saleService.getAllSales();
    }

    @GetMapping("/{id}")
    public Sale getSaleById(@PathVariable("id") Long id) {
        return saleService.getSaleById(id);
    }

    @DeleteMapping("/{id}/delete")
    public ResponseEntity<Sale> deleteSaleById(@PathVariable("id") Long id) {
        Sale deletedSale = saleService.getSaleById(id);
        saleService.deleteSaleById(id);
        return new ResponseEntity<Sale>(deletedSale, HttpStatus.OK);
    }
}
