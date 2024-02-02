// src/test/java/com/example/demo/CalculatorServiceTest.java
package com.example.demo;
//package com.example.demo.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
//import com.example.demo.service.CalculatorService;


public class CalculatorServiceTest {

    @Test
    public void testAdd() {
        CalculatorService calculatorService = new CalculatorService();
        int result = calculatorService.add(2, 3);
        assertEquals(5, result);
    }
}
