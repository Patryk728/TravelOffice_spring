package com.example.demo.controller;

import com.example.demo.model.Adress;
import com.example.demo.model.Customer;
import com.example.demo.model.MyDate;
import com.example.demo.model.Trip;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldGetAll() throws Exception {
        this.mockMvc.perform(get("/customers"))
                .andExpect(status().isOk());
    }
    @Test
    public  void shouldAddCustomer() throws Exception {
        Customer customer = createCustomer();
        assertThat(customer.getId()).isNotNull();
        assertThat(customer.getName()).isEqualTo("TestValue");
    }

    private Customer createCustomer() throws Exception {
        Customer customer = getCustomer();

        String postValue = OBJECT_MAPPER.writeValueAsString(customer);
        System.out.println(postValue);
        MvcResult storyResult = mockMvc.perform(MockMvcRequestBuilders
                                .post("/addCustomers")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(postValue))
                                .andExpect(status().isOk())
                                .andDo(print())
                                .andReturn();

        return OBJECT_MAPPER.readValue(storyResult.getResponse().getContentAsString(), Customer.class);
    }

    private Customer getCustomer() {
        Customer customer = new Customer();
        Adress adress = new Adress("piotrkowska","99-420","Lodz");
        MyDate start = new MyDate(2019,10,12);
        MyDate end = new MyDate(2019,10,22);
        Trip trip = new Trip(start,end,"Polska",1000.50);

        customer.setId((80L));
        customer.setName("TestValue");
        customer.setAdres(adress);
        customer.setTrip(trip);
        return customer;
    }


}
