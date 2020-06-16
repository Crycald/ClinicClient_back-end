package com.client.clientapi.client;

import com.client.clientapi.domain.api.IpifyDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.Scanner;

@Component
public class IpifyClient {

    @Value("${ipify.api.endpoint.prod}")
    private String ipifyApiEndpoint;

    private IpifyDto ipifyDto = new IpifyDto();

    public IpifyDto getIp() {
        try (Scanner scanner = new Scanner(new URL(ipifyApiEndpoint).openStream(), "UTF-8").useDelimiter("\\A")) {
            ipifyDto.setIpAddress(scanner.next().replace("ip", "")
                    .replace("{", "")
                    .replace("}","")
                    .replace(":", "")
                    .replace("\"", ""));
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
        return ipifyDto;
    }
}
