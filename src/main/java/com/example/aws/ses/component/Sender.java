package com.example.aws.ses.component;

import com.amazonaws.AmazonClientException;
import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.example.aws.ses.domain.SenderDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class Sender {

    private final AmazonSimpleEmailService amazonSimpleEmailService;

    public void send(String from, List<String> to, String subject, String content) {
        try {
            final SenderDto senderDto = new SenderDto(from, to, subject, content);
            amazonSimpleEmailService.sendEmail(senderDto.toSendRequestDto());
        } catch (Exception ex) {
            throw new AmazonClientException(ex.getMessage(), ex);
        }
    }

}