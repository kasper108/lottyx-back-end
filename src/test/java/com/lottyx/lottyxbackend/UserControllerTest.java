package com.lottyx.lottyxbackend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lottyx.lottyxbackend.controller.UserController;
import com.lottyx.lottyxbackend.model.User;
import com.lottyx.lottyxbackend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest( UserController.class )
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Test
    public void getUserByIdTest() throws Exception {

        User user = new User();
        user.setName("John");
        user.setSurname("Doe");
        user.setEmail("john@doe.com");
        user.setPassword("qwerty");

        when(userService.getUserById(anyLong())).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/user/13"))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("Doe"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("john@doe.com"))
                .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("qwerty"))
                .andExpect(status().isOk());
    }

    @Test
    public void saveUserTest() throws Exception {
        User user = new User();
        user.setId(12L);
        user.setName("John");
        user.setSurname("Doe");
        user.setEmail("john@doe.com");
        user.setPassword("qwerty");

        when(userService.postNewUser(any(User.class))).thenReturn(user);

        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/user/")
                        .content(new ObjectMapper().writeValueAsString(user))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isCreated())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.id").exists())
                        .andExpect(MockMvcResultMatchers.jsonPath("$.name").value("John"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.surname").value("Doe"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.email").value("john@doe.com"))
                        .andExpect(MockMvcResultMatchers.jsonPath("$.password").value("qwerty"));

    }
}
