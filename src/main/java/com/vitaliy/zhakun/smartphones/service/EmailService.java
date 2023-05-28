package com.vitaliy.zhakun.smartphones.service;

import com.vitaliy.zhakun.smartphones.model.EmailDetails;

public interface EmailService {
    void sendSimpleMail(EmailDetails details);
    //String sendMailWithAttachment(EmailDetails details);
}
