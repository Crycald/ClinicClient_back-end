package com.client.clientapi.scheduler;

import com.client.clientapi.domain.OperationConnectorDto;
import com.client.clientapi.service.OperationConnectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class DbCleaner {
    private Logger logger = LoggerFactory.getLogger(DbCleaner.class);
    private OperationConnectorService operationConnectorService;
    private final LocalDate localDateNow = LocalDate.now();

    @Autowired
    public DbCleaner(OperationConnectorService operationConnectorService) {
        this.operationConnectorService = operationConnectorService;
    }

    @Scheduled(cron = "0 32 20 ? * MON-FRI") // 20.30 5times in a week
    public void checkOperationConnectorEntityAndRemoveWhenDateExpires() {
        logger.warn("DbCleaner - START");

        List<OperationConnectorDto> list = operationConnectorService.getOperationConnectors();

        for (OperationConnectorDto iterator : list) {
            if (iterator.getDate().equals(localDateNow)) {
                logger.info("Operation connector with expired date: " + iterator.getDate() + " identified by ID: " + iterator.getId());
                operationConnectorService.deleteOperationConnector(iterator.getId());
            }
        }
        logger.warn("DbCleaner - END");
    }
}
