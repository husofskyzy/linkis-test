package org.apache.linkis.resourcemanager.utils; 
 
import org.h2.tools.Server;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

/** 
 * RequestKerberosUrlUtils Tester
*/ 
public class RequestKerberosUrlUtilsTest {
    private static RequestKerberosUrlUtils requestKerberosUrlUtils;

    @BeforeAll
    @DisplayName("Each unit test method is executed once before execution")
    protected static void beforeAll() throws Exception {
        requestKerberosUrlUtils = new RequestKerberosUrlUtils("principal","keyTabLocation");
    }

    @AfterAll
    @DisplayName("Each unit test method is executed once after execution")
    protected static void afterAll() throws Exception {}
 
 
    @Test
    @DisplayName("Method description: ...")
    public void testCallRestUrl() throws Exception {
        requestKerberosUrlUtils.callRestUrl("url","useKeyTab");
    }
 
 

    @Test
    @DisplayName("Method description: ...")
    public void testBuildSpengoHttpClient() throws Exception { 
        //TODO private方法无法调用
//        requestKerberosUrlUtils.buildSpengoHttpClient();
    }
 
} 
