package org.apache.linkis.resourcemanager.utils; 
 
import org.h2.tools.Server;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

/** 
 * AlertUtils Tester
*/ 
public class AlertUtilsTest {
    @BeforeAll
    @DisplayName("Each unit test method is executed once before execution")
    protected static void beforeAll() throws Exception {
    }

    @AfterAll
    @DisplayName("Each unit test method is executed once after execution")
    protected static void afterAll() throws Exception {}
 
    @Test
    @DisplayName("Method description: ...")
    public void testSendAlertAsync() throws Exception {
        AlertUtils.sendAlertAsync("title1","info1");
    }

    @Test
    @DisplayName("Method description: ...")
    public void testGetContactByQueue() throws Exception {
        AlertUtils.getContactByQueue("queue1");
    }
 
}
