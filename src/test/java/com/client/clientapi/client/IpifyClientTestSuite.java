package com.client.clientapi.client;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IpifyClientTestSuite {

    @Value("${MY_OWN_IP_ADDRESS}")
    private String myOwnIpAddress;

    @Autowired
    private IpifyClient ipifyClient;

    @Test
    public void getIpTest() {
        String getIp = ipifyClient.getIp().toString()
                .replace("IpifyDto", "")
                .replace("(", "")
                .replace(")","")
                .replace("Address", "")
                .replace("=", "")
                .replace("ip", "");

        Assert.assertEquals(myOwnIpAddress, getIp);
    }
}
