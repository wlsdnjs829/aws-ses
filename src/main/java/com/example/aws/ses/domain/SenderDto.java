package com.example.aws.ses.domain;

import com.amazonaws.services.simpleemail.model.Body;
import com.amazonaws.services.simpleemail.model.Content;
import com.amazonaws.services.simpleemail.model.Destination;
import com.amazonaws.services.simpleemail.model.Message;
import com.amazonaws.services.simpleemail.model.SendEmailRequest;

import java.nio.charset.StandardCharsets;
import java.util.List;

public record SenderDto(
        String from,
        List<String> to,
        String subject,
        String content
) {

    public void addTo(String email) {
        this.to.add(email);
    }

    public SendEmailRequest toSendRequestDto() {
        final Destination destination = new Destination()
                .withToAddresses(this.to);

        final Message message = new Message()
                .withSubject(createContent(this.subject))
                .withBody(new Body().withHtml(createContent(this.content)));

        return new SendEmailRequest()
                .withSource(this.from)
                .withDestination(destination)
                .withMessage(message);
    }

    private Content createContent(String text) {
        return new Content()
                .withCharset(StandardCharsets.UTF_8.name())
                .withData(text);
    }

}
