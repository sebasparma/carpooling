package com.pragma.carpooling.controller;

import com.pragma.carpooling.dto.UserDTO;
import com.pragma.carpooling.factory.UserDataFactory;
import com.pragma.carpooling.service.UserService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@WebMvcTest(UserController.class)
class UserControllerTest {

    @MockBean
    UserService userService;

    @Autowired
    private MockMvc mvc;

    @Test
    void saveUserAllFields() throws Exception {
        UserDTO userDTO = UserDataFactory.getUserDTOFull();
        String uri = "/user";
        String userJson = UserDataFactory.getUserJson();
        when(userService.saveUser(any())).thenReturn(userDTO);

        RequestBuilder request = MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON)
                .content(userJson).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(request).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString();
        Assertions.assertThat(outputJson).contains("user@email.com");

    }

    @Test
    void saveUserEmptyFieldsRequiredValidation() throws Exception {
        String uri = "/user";
        String userJson = UserDataFactory.getUserJsonEmpty();

        RequestBuilder request = MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON)
                .content(userJson).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(request).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString();
        Assertions.assertThat(outputJson).contains("Name is required");
        Assertions.assertThat(outputJson).contains("Last name is required");
        Assertions.assertThat(outputJson).contains("Address is required");
        Assertions.assertThat(outputJson).contains("Phone number is required");
        Assertions.assertThat(outputJson).contains("Email is required");

    }

    @Test
    void saveUserInvalidPassword() throws Exception {
        String uri = "/user";
        String userJson = UserDataFactory.getUserJsonInvalidPassword();

        RequestBuilder request = MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON)
                .content(userJson).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(request).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString();
        Assertions.assertThat(outputJson).contains("Invalid password");

    }

    @Test
    void saveUserInvalidEmail() throws Exception {
        String uri = "/user";
        String userJson = UserDataFactory.getUserJsonInvalidEmail();

        RequestBuilder request = MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON)
                .content(userJson).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(request).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString();
        Assertions.assertThat(outputJson).contains("Invalid email");

    }

    @Test
    void saveUserNull() throws Exception {
        String uri = "/user";

        RequestBuilder request = MockMvcRequestBuilders.post(uri).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(request).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString();
        Assertions.assertThat(outputJson).contains("Data not provided");

    }

    @Test
    void findUserByEmail() throws Exception {
        String uri = "/user/findByEmail?email=user@email.com";
        UserDTO userDTO = UserDataFactory.getUserDTOFull();

        when(userService.findByEmail(anyString())).thenReturn(userDTO);
        RequestBuilder request = MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(request).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString();
        System.out.println(outputJson);
        Assertions.assertThat(outputJson).contains("user@email.com");
    }

    @Test
    void findUserByEmailNotProvided() throws Exception {
        String uri = "/user/findByEmail";
        UserDTO userDTO = UserDataFactory.getUserDTOFull();

        when(userService.findByEmail(anyString())).thenReturn(userDTO);
        RequestBuilder request = MockMvcRequestBuilders.get(uri)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mvc.perform(request).andReturn();
        MockHttpServletResponse response = result.getResponse();

        String outputJson = response.getContentAsString();
        System.out.println(outputJson);
        Assertions.assertThat(outputJson).contains("Email not provided");
    }
}