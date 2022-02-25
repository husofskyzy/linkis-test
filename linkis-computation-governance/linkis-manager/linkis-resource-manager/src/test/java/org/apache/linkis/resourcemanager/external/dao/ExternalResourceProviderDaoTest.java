package org.apache.linkis.resourcemanager.external.dao;

import org.apache.linkis.resourcemanager.external.domain.ExternalResourceProvider;
import org.h2.tools.Server;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

public class ExternalResourceProviderDaoTest extends BaseDaoTest{
    @Autowired
    private ExternalResourceProviderDao externalResourceProviderDao;

    @BeforeAll
    @DisplayName("Each unit test method is executed once before execution")
    protected static void beforeAll() throws Exception {
        // Start the console of h2 to facilitate viewing of h2 data
        Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
    }

    @AfterAll
    @DisplayName("Each unit test method is executed once after execution")
    protected static void afterAll() throws Exception {}

    @Test
    void testSelectByResourceType() {
        List<ExternalResourceProvider> result = externalResourceProviderDao.selectByResourceType("Yarn");
        assertEquals(result.size(), 1);
    }
}
