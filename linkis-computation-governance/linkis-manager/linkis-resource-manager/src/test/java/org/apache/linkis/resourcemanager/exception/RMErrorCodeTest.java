package org.apache.linkis.resourcemanager.exception; 
 
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** 
 * RMErrorCode Tester
*/ 
public class RMErrorCodeTest { 
 
    @Autowired
    private RMErrorCode rMErrorCode;
 
    @BeforeEach
    @DisplayName("Each unit test method is executed once before execution")
    public void before() throws Exception {
    }
 
    @AfterEach
    @DisplayName("Each unit test method is executed once before execution")
    public void after() throws Exception {
    }

    @Test
    @DisplayName("Method description: ...")
    public void testGetCode() throws Exception {
        assertEquals(12011,RMErrorCode.CLUSTER_QUEUE_CPU_INSUFFICIENT.getCode());
    }

    @Test
    @DisplayName("Method description: ...")
    public void testGetMessage() throws Exception {
        assertEquals("Insufficient cluster queue cpu",RMErrorCode.CLUSTER_QUEUE_CPU_INSUFFICIENT.getMessage());
    }
 
 
} 
