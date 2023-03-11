package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;

@RunWith(SpringRunner.class)
@WebMvcTest(BinaryController.class)
public class BinaryControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void getDefault() throws Exception {
        this.mvc.perform(get("/"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", ""))
			.andExpect(model().attribute("operand1Focused", false));
    }
	
    @Test
    public void getParameter() throws Exception {
        this.mvc.perform(get("/").param("operand1","111"))
            .andExpect(status().isOk())
            .andExpect(view().name("calculator"))
			.andExpect(model().attribute("operand1", "111"))
			.andExpect(model().attribute("operand1Focused", true));
    }


    //ADD
    /**
     * Test The add functions with two binary numbers of the same length
     */
    @Test
	    public void postParameterAdd() throws Exception {
        this.mvc.perform(post("/").param("operand1","1000").param("operator","+").param("operand2","1111"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(view().name("result"))
			.andExpect(model().attribute("result", "10111"))
			.andExpect(model().attribute("operand1", "1000"));
    }

    /**
     * Test The add functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void postParameterAdd2() throws Exception {
        this.mvc.perform(post("/").param("operand1","1010").param("operator","+").param("operand2","11"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1101"))
                .andExpect(model().attribute("operand1", "1010"));
    }

    /**
     * Test The add functions with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void postParameterAdd3() throws Exception {
        this.mvc.perform(post("/").param("operand1","11").param("operator","+").param("operand2","1010"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1101"))
                .andExpect(model().attribute("operand1", "11"));
    }

    /**
     * Test The add functions with a binary numbers with zero
     */
    @Test
    public void postParameterAdd4() throws Exception {
        this.mvc.perform(post("/").param("operand1","0").param("operator","+").param("operand2","1010"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1010"))
                .andExpect(model().attribute("operand1", "0"));
    }

    /**
     * Test The add functions with two zeros
     */
    @Test
    public void postParameterAdd5() throws Exception {
        this.mvc.perform(post("/").param("operand1","0").param("operator","+").param("operand2","0"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }

    //------------------------------------------------------------------------------------------------------------------
    //AND
    /**
     * Test The and functions with two binary numbers of the same length
     */
    @Test
    public void postParameterAnd() throws Exception {
        this.mvc.perform(post("/").param("operand1","1000").param("operator","&").param("operand2","1111"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1000"))
                .andExpect(model().attribute("operand1", "1000"));
    }

    /**
     * Test The and functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void postParameterAnd2() throws Exception {
        this.mvc.perform(post("/").param("operand1","1010").param("operator","&").param("operand2","11"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "10"))
                .andExpect(model().attribute("operand1", "1010"));
    }

    /**
     * Test The and functions with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void postParameterAnd3() throws Exception {
        this.mvc.perform(post("/").param("operand1","11").param("operator","&").param("operand2","1010"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "10"))
                .andExpect(model().attribute("operand1", "11"));
    }

    /**
     * Test The and functions with a binary numbers with zero
     */
    @Test
    public void postParameterAnd4() throws Exception {
        this.mvc.perform(post("/").param("operand1","0").param("operator","&").param("operand2","1010"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }

    /**
     * Test The and functions with two zeros
     */
    @Test
    public void postParameterAnd5() throws Exception {
        this.mvc.perform(post("/").param("operand1","0").param("operator","&").param("operand2","0"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }

    //------------------------------------------------------------------------------------------------------------------
    //OR
    /**
     * Test The OR functions with two binary numbers of the same length
     */
    @Test
    public void postParameterOr() throws Exception {
        this.mvc.perform(post("/").param("operand1","1000").param("operator","|").param("operand2","1111"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1111"))
                .andExpect(model().attribute("operand1", "1000"));
    }

    /**
     * Test The OR functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void postParameterOr2() throws Exception {
        this.mvc.perform(post("/").param("operand1","1010").param("operator","|").param("operand2","11"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1011"))
                .andExpect(model().attribute("operand1", "1010"));
    }

    /**
     * Test The OR functions with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void postParameterOr3() throws Exception {
        this.mvc.perform(post("/").param("operand1","11").param("operator","|").param("operand2","1010"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1011"))
                .andExpect(model().attribute("operand1", "11"));
    }

    /**
     * Test The OR functions with a binary numbers with zero
     */
    @Test
    public void postParameterOr4() throws Exception {
        this.mvc.perform(post("/").param("operand1","0").param("operator","|").param("operand2","1010"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1010"))
                .andExpect(model().attribute("operand1", "0"));
    }

    /**
     * Test The OR functions with two zeros
     */
    @Test
    public void postParameterOr5() throws Exception {
        this.mvc.perform(post("/").param("operand1","0").param("operator","|").param("operand2","0"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "0"))
                .andExpect(model().attribute("operand1", "0"));
    }

    //------------------------------------------------------------------------------------------------------------------
    //MULTIPLY
    /**
     * Test The Multiplication functions with two binary numbers of the same length
     */
    @Test
    public void postParameterMultiply() throws Exception {
        this.mvc.perform(post("/").param("operand1","1000").param("operator","*").param("operand2","1111"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "1111000"))
                .andExpect(model().attribute("operand1", "1000"));
    }

    /**
     * Test The Multiplication functions with two binary numbers, the length of the first argument is less than the second
     */
    @Test
    public void postParameterMultiply2() throws Exception {
        this.mvc.perform(post("/").param("operand1","1010").param("operator","*").param("operand2","11"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "11110"))
                .andExpect(model().attribute("operand1", "1010"));
    }

    /**
     * Test The Multiplication functions with two binary numbers, the length of the first argument is greater than the second
     */
    @Test
    public void postParameterMultiply3() throws Exception {
        this.mvc.perform(post("/").param("operand1","11").param("operator","*").param("operand2","1010"))//.andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attribute("result", "11110"))
                .andExpect(model().attribute("operand1", "11"));
    }
}
