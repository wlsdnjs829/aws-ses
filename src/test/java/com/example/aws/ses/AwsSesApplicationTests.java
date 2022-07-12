package com.example.aws.ses;

import com.example.aws.ses.component.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AwsSesApplicationTests {

    @Autowired
    private Sender sender;

    @Test
    void sendTest() {
        sender.send("ljw0829@midasin.com", List.of("ljw0829@midasin.com"), "test", "content");
    }

}
