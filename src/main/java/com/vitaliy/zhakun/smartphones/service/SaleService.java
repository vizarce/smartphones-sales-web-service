package com.vitaliy.zhakun.smartphones.service;

import com.vitaliy.zhakun.smartphones.model.Customer;
import com.vitaliy.zhakun.smartphones.model.Manager;
import com.vitaliy.zhakun.smartphones.model.Sale;
import com.vitaliy.zhakun.smartphones.model.Smartphone;

import java.util.List;

public interface SaleService {

    Sale createSale(Long smartphoneId, Long managerId, Long customerId, int quantity);

    List<Sale> getAllSales();

    Sale getSaleById(Long id);

    void deleteSaleById(Long id);
}
