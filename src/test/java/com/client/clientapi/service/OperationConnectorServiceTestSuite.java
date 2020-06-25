package com.client.clientapi.service;

import com.client.clientapi.domain.ClinicDto;
import com.client.clientapi.domain.CustomerDto;
import com.client.clientapi.domain.OperationConnectorDto;
import com.client.clientapi.domain.OperationDto;
import com.client.clientapi.domain.enums.TypeOfAnimal;
import com.client.clientapi.domain.enums.TypeOfOperation;
import com.client.clientapi.exception.connector.OperationConnectorNotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OperationConnectorServiceTestSuite {
    @Autowired
    private OperationConnectorService service;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ClinicService clinicService;

    @Autowired
    private OperationService operationService;

    @Test
    public void createOperationConnectorTest() {
        ClinicDto clinic1 = new ClinicDto();
        clinic1.setName("comp_name");
        clinic1.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic1.setAddress("address");
        clinic1.setNip(12312312312L);
        clinic1.setPhoneNumber("123-123-123");
        clinic1.setMail("mail@mail.com");
        clinic1.setLogin("login");
        clinic1.setPassword("pwd123");

        CustomerDto customer = new CustomerDto();
        customer.setId(1L);
        customer.setFirstname("Chris");
        customer.setLastname("Mops");
        customer.setLogin("testLogin");
        customer.setPassword("123pwd");
        customer.setEmail("mail@mail.com");
        customer.setPhoneNumber("123-123-123");

        ClinicDto test = clinicService.createClinic(clinic1);
        Long clinicId = test.getId();

        CustomerDto test4 = customerService.createCustomer(customer);
        Long customerId = test4.getId();

        OperationDto operation = new OperationDto();
        operation.setClinicId(clinicId);
        operation.setOperations(TypeOfOperation.AMPUTACJA);
        operation.setCost(new BigDecimal(3000));

        OperationDto test2 = operationService.createOperation(operation);
        Long operationId = test2.getId();

        OperationConnectorDto operationConnector = new OperationConnectorDto();
        operationConnector.setClinicId(operation.getClinicId());
        operationConnector.setOperationActId(operationId);
        operationConnector.setCustomerId(customerId);

        OperationConnectorDto test3 = service.createOperationConnector(operationConnector);
        Long operationConnectorId = test3.getId();

        Assert.assertNotNull(service.getOperationConnectorById(operationConnectorId));

        service.deleteOperationConnector(operationConnectorId);
        customerService.deleteCustomer(customerId);
        clinicService.deleteClinic(clinicId);
    }

    @Test
    public void updateOperationConnectorTest() {
        ClinicDto clinic1 = new ClinicDto();
        clinic1.setName("comp_name");
        clinic1.setTypeOfAnimal(TypeOfAnimal.FRETKA);
        clinic1.setAddress("address");
        clinic1.setNip(12312312312L);
        clinic1.setPhoneNumber("123-123-123");
        clinic1.setMail("mail@mail.com");
        clinic1.setLogin("login");
        clinic1.setPassword("pwd123");

        CustomerDto customer = new CustomerDto();
        customer.setId(1L);
        customer.setFirstname("Chris");
        customer.setLastname("Mops");
        customer.setLogin("testLogin");
        customer.setPassword("123pwd");
        customer.setEmail("mail@mail.com");
        customer.setPhoneNumber("123-123-123");

        CustomerDto customer2 = new CustomerDto();
        customer2.setId(1L);
        customer2.setFirstname("Chris");
        customer2.setLastname("Mops");
        customer2.setLogin("testLogin");
        customer2.setPassword("123pwd");
        customer2.setEmail("mail@mail.com");
        customer2.setPhoneNumber("123-123-123");

        ClinicDto test = clinicService.createClinic(clinic1);
        Long clinicId = test.getId();

        CustomerDto test4 = customerService.createCustomer(customer);
        Long customerId = test4.getId();

        CustomerDto test5 = customerService.createCustomer(customer2);
        Long customerId2 = test5.getId();

        OperationDto operation = new OperationDto();
        operation.setClinicId(clinicId);
        operation.setOperations(TypeOfOperation.AMPUTACJA);
        operation.setCost(new BigDecimal(3000));

        OperationDto test2 = operationService.createOperation(operation);
        Long operationId = test2.getId();

        OperationConnectorDto operationConnector = new OperationConnectorDto();
        operationConnector.setClinicId(operation.getClinicId());
        operationConnector.setOperationActId(operationId);
        operationConnector.setCustomerId(customerId);

        OperationConnectorDto test3 = service.createOperationConnector(operationConnector);
        Long operationConnectorId = test3.getId();

        OperationConnectorDto operationConnector2 = new OperationConnectorDto();
        operationConnector2.setId(operationConnectorId);
        operationConnector2.setClinicId(operation.getClinicId());
        operationConnector2.setOperationActId(operationId);
        operationConnector2.setCustomerId(customerId2);

        service.updateOperationConnector(operationConnector2);

        Assert.assertNotEquals(operationConnector.getCustomerId(), operationConnector2.getCustomerId());

        service.deleteOperationConnector(operationConnectorId);
        customerService.deleteCustomer(customerId);
        customerService.deleteCustomer(customerId2);
        clinicService.deleteClinic(clinicId);
    }

    @Test(expected = OperationConnectorNotFoundException.class)
    public void deleteOperationConnectorThrowOperationConnectorNotFoundException() {
        Long id = 31232151524352315L;
        service.deleteOperationConnector(id);
    }
}
