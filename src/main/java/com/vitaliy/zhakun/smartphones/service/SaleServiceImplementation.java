package com.vitaliy.zhakun.smartphones.service;

import com.vitaliy.zhakun.smartphones.model.*;
import com.vitaliy.zhakun.smartphones.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SaleServiceImplementation implements SaleService {

    private final SaleRepository saleRepository;

    private final SmartphoneRepository smartphoneRepository;

    private final ManagerRepository managerRepository;

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    private final EmailService emailService;

    @Autowired
    public SaleServiceImplementation(SaleRepository saleRepository,
                                     SmartphoneRepository smartphoneRepository,
                                     ManagerRepository managerRepository,
                                     CustomerRepository customerRepository,
                                     OrderRepository orderRepository,
                                     EmailService emailService) {
        this.saleRepository = saleRepository;
        this.smartphoneRepository = smartphoneRepository;
        this.managerRepository = managerRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
        this.emailService = emailService;
    }

    @Override
    @Transactional
    public Sale createSale(Long smartphoneId, Long managerId, Long customerId, int quantity) {
        Long nextId = nextId();
        Sale sale = new Sale();
        sale.setId(nextId);
        Optional<Smartphone> optionalSmartphone = smartphoneRepository.findById(smartphoneId);
        if (optionalSmartphone.isEmpty())
            throw new IllegalStateException("Smartphone with Id = " + smartphoneId + " was not found. Try once more.");
        Smartphone smartphone = optionalSmartphone.get();
        sale.setSmartphone(smartphone);
        Optional<Manager> optionalManager = managerRepository.findById(managerId);
        if (optionalManager.isEmpty())
            throw new IllegalStateException("Manager with Id = " + managerId + " was not found. Try once more.");
        Manager manager = optionalManager.get();
        sale.setManager( manager);
        Optional<Customer> optionalCustomer = customerRepository.findById(customerId);
        if (optionalCustomer.isEmpty())
            throw new IllegalStateException("Customer with Id = " + customerId + " was not found. Try once more.");
        Customer customer = optionalCustomer.get();
        sale.setCustomer(customer);
        if (quantity > smartphone.getQuantity())
            throw new IllegalStateException("Desired Smartphones quantity = " + smartphone.getQuantity() + ", what less than exist in the store. Choose less or ask to order more.");
        smartphone.setQuantity(smartphone.getQuantity() - quantity);
        smartphoneRepository.save(smartphone);
        manager.setSales(manager.getSales() + quantity);
        managerRepository.save(manager);
        sale.setQuantity(quantity);
        sale.setInitialPrice(smartphone.getOriginalPriceUsd());
        double discount;
        //String discountStr;
        if (customer.isGoldMember()) {
            //discountStr = String.format("%.2f",smartphone.getGoldMembersDiscount() * smartphone.getOriginalPriceUsd());
            discount = smartphone.getGoldMembersDiscount() * smartphone.getOriginalPriceUsd();//Double.valueOf(discountStr);
        } else if (customer.isSilverMember()) {
        	//discountStr = String.format("%.2f", smartphone.getSilverMembersDiscount() * smartphone.getOriginalPriceUsd());
        	discount = smartphone.getSilverMembersDiscount() * smartphone.getOriginalPriceUsd();//Double.valueOf(discountStr);
        } else {
            discount = 0;
        }
        sale.setDiscount(discount);
        double finalPrice = smartphone.getOriginalPriceUsd() - discount;
        sale.setFinalPrice(finalPrice);
        customer.setBallance(customer.getBallance() - finalPrice);
        customerRepository.save(customer);
        sale.setCustomer(customer);
        Order order = new Order();
        Long orderId;
        long orderIdsCount = orderRepository.count();
        if (orderIdsCount == 0) {
            orderId = 1L;
        } else {
            //Collections.sort(orderIds);
            //Collections.reverse(orderIds);
            orderId = orderIdsCount + 1;
        }
        order.setId(orderId);
        order.setSaleId(nextId);
        order.setOrderIdenentificator("ODR" + String.valueOf(LocalDateTime.now())
                .replaceAll("-", "")
                .replaceAll(":", "")
                .replace(".", "")
                .replace("T", "") + String.valueOf(smartphone.getId()));
        order.setCustomer(customer);
        order.setSaleDate(LocalDate.now());
        order.setSaleTime(LocalTime.now());
        order.setDespatchDate(LocalDate.from(LocalDate.now().plusDays(1)));
        order.setActualPrice(smartphone.getOriginalPriceUsd());
        order.setDiscount(discount);
        order.setRealPrice(finalPrice);
        orderRepository.save(order);
        sale.setOrder(order);
        EmailDetails details = new EmailDetails();
        details.setRecipient("vizarce@gmail.com");
        details.setMsgBody("Congratulations! You have just bought new Smartphone "
                + smartphone.getBrand() + " " + smartphone.getModel() + " "
                + smartphone.getSubModel() + " for " + finalPrice + " dollars");
        details.setSubject("You have got new Smartphone!");
        emailService.sendSimpleMail(details);
        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    @Override
    public Sale getSaleById(Long id) {
        Optional<Sale> optionalSale = saleRepository.findById(id);
        if (optionalSale.isEmpty())
            throw new IllegalStateException("Sale with id = " + id + " does not exist in Database.");
        return optionalSale.get();
    }

    @Override
    @Transactional
    public void deleteSaleById(Long id) {
        Optional<Sale> optionalSale = saleRepository.findById(id);
        if (optionalSale.isEmpty())
            throw new IllegalStateException("Sale with id = " + id + " does not exist in Database.");
        else
            saleRepository.deleteById(id);

    }

    private Long nextId() {
        Long saleId;
        long salesIdsCount = saleRepository.count();
        if (salesIdsCount == 0) {
            saleId = 1L;
        } else {
            //Collections.sort(iDs);
            //Collections.reverse(iDs);
            saleId = salesIdsCount + 1;
        }
        return saleId;
    }
}
