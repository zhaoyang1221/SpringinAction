package spittr.web;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

/**
 * <p>Title: SpitterControllerTest</p>
 *
 * @description: 用户测试类
 * @author: xiongzy
 * @date: 2018-10-23
 **/
public class SpitterControllerTest {

    @Test
    public void shouldShowRegister() throws Exception {
        SpitterController controller = new SpitterController();
        MockMvc mockMvc = standaloneSetup(controller).build();

        mockMvc.perform(get("/spitter/register"))
                .andExpect(view().name("registerForm"));
    }

    @Test
    public void shouldProcessRegistration() throws Exception {
        SpitterRepository spitterRepository = mock(SpitterRepository.class);
        Spitter unsaved = new Spitter("jbauer", "24hours", "Jack", "Bauer", "123@123.com");
        Spitter saved = new Spitter(24L,"jbauer", "24hours", "Jack", "Bauer", "123@123.com");

        when(spitterRepository.save(unsaved))
                .thenReturn(saved);

        SpitterController controller = new SpitterController(spitterRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .build();

        mockMvc.perform(post("/spitter/register")
                .param("firstName", "Jack")
                .param("lastName", "Bauer")
                .param("username", "jbauer")
                .param("password", "24hours")
                .param("email", "123@123.com"))
                .andExpect(redirectedUrl("/spitter/jbauer"));

        verify(spitterRepository, atLeastOnce()).save(unsaved);


    }
}