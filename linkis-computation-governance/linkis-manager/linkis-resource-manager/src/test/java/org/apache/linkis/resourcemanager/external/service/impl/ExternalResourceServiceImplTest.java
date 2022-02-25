package org.apache.linkis.resourcemanager.external.service.impl; 
 


import com.google.common.collect.Maps;
import org.apache.linkis.manager.common.entity.resource.ResourceType;
import org.apache.linkis.manager.label.entity.Label;
import org.apache.linkis.manager.label.entity.cluster.ClusterLabel;
import org.apache.linkis.resourcemanager.domain.RMLabelContainer;
import org.apache.linkis.resourcemanager.external.dao.ExternalResourceProviderDao;
import org.apache.linkis.resourcemanager.external.yarn.YarnResourceIdentifier;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** 
 * ExternalResourceServiceImpl Tester
*/
@ExtendWith(MockitoExtension.class)
public class ExternalResourceServiceImplTest {
    @Mock
    private ExternalResourceProviderDao externalResourceProviderDao;

    @InjectMocks
    private ExternalResourceServiceImpl externalResourceServiceImpl;

    @BeforeAll
    @DisplayName("Each unit test method is executed once before execution")
    protected static void beforeAll() throws Exception {
    }

    @AfterAll
    @DisplayName("Each unit test method is executed once after execution")
    protected static void afterAll() throws Exception {}
 
 
    @Test
    @DisplayName("Method description: ...")
    public void testGetResourceByMap() throws Exception {
        Map<String,Object> map = null;
        Label<?> label = new ClusterLabel();
        List<Label<?>> labels = null;
        RMLabelContainer rMLabelContainer = new RMLabelContainer(labels);
        externalResourceServiceImpl.getResource(ResourceType.Yarn,rMLabelContainer, map);
    }

    @Test
    @DisplayName("Method description: ...")
    public void testGetResourceByIdentifier() throws Exception {
        externalResourceServiceImpl.getResource(ResourceType.Yarn,null,new YarnResourceIdentifier("queueName"));
    }

    @Test
    @DisplayName("Method description: ...")
    public void testGetAppInfoByMap() throws Exception {
//        externalResourceServiceImpl.getAppInfo(ResourceType.Yarn,);
    }

    @Test
    @DisplayName("Method description: ...")
    public void testGetAppInfoByIdentifier() throws Exception {
//        externalResourceServiceImpl.getAppInfo(ResourceType.Yarn,);
    }
} 
