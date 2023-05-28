package com.vitaliy.zhakun.smartphones.service;

import com.vitaliy.zhakun.smartphones.model.Smartphone;
import java.util.List;

public interface SmartphoneService {

    List<Smartphone> getAllSmartphones();

    List<Smartphone> getAllSmartphonesSorted(String order);

    Smartphone getSmartphoneById(Long id);

    Smartphone createSmartphone(Smartphone smartPhone);

    List<Smartphone> createSmartphones(Iterable<Smartphone> smartPhones);

    Smartphone updateSmartphone(Smartphone smartPhone, Long id);

    void deleteSmartphoneById(Long id);
}
