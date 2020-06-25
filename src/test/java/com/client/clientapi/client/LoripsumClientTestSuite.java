package com.client.clientapi.client;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoripsumClientTestSuite {
    @Autowired
    private LoripsumClient loripsumClient;

    @Test
    public void generateLiripsumTest() {
        String generatedText = loripsumClient.getLoripsum();

        Assert.assertNotNull(generatedText);
    }
}
