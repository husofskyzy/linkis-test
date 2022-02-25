package org.apache.linkis.resourcemanager.external.domain; 
 
import com.google.gson.reflect.TypeToken;
import org.apache.linkis.server.BDPJettyServerHelper;
import org.h2.tools.Server;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/** 
 * ExternalResourceProvider Tester
*/ 
public class ExternalResourceProviderTest {

    @BeforeAll
    @DisplayName("Each unit test method is executed once before execution")
    protected static void beforeAll() throws Exception {
    }

    @AfterAll
    @DisplayName("Each unit test method is executed once after execution")
    protected static void afterAll() throws Exception {}

    @Test
    @DisplayName("Method description: ...")
    public void testGetConfigMap() throws Exception {
        String config = "{\r\n\"rmWebAddress\": \"@YARN_RESTFUL_URL\",\r\n\"hadoopVersion\": \"2.7.2\",\r\n\"authorEnable\":false,\r\n\"user\":\"hadoop\",\r\n\"pwd\":\"123456\",\r\n\"kerberosEnable\":@KERBEROS_ENABLE,\r\n\"principalName\":\"@PRINCIPAL_NAME\",\r\n\"keytabPath\":\"@KEYTAB_PATH\",\r\n\"krb5Path\":\"@KRB5_PATH\"\r\n}";
        ExternalResourceProvider externalResourceProvider = new ExternalResourceProvider();
        externalResourceProvider.config = config;
        assertNotEquals(0,externalResourceProvider.getConfigMap().size());
    }
} 
