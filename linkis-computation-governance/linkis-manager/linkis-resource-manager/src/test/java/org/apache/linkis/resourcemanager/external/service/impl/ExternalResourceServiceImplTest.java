package org.apache.linkis.resourcemanager.external.service.impl;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.linkis.manager.common.entity.resource.ResourceType;
import org.apache.linkis.manager.label.entity.Label;
import org.apache.linkis.manager.label.entity.cluster.ClusterLabel;
import org.apache.linkis.resourcemanager.domain.RMLabelContainer;
import org.apache.linkis.resourcemanager.external.dao.BaseDaoTest;
import org.apache.linkis.resourcemanager.external.dao.ExternalResourceProviderDao;
import org.apache.linkis.resourcemanager.external.yarn.YarnResourceIdentifier;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/** 
 * ExternalResourceServiceImpl Tester
*/
@ExtendWith(MockitoExtension.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ExternalResourceServiceImplTest extends BaseDaoTest {
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
//        externalResourceServiceImpl.getResource(ResourceType.Yarn,rMLabelContainer, map);
    }

    @Test
    @DisplayName("Method description: ...")
    public void testGetResourceByIdentifier() throws Exception {
//        externalResourceServiceImpl.getResource(ResourceType.Yarn,null,new YarnResourceIdentifier("queueName"));
    }

    @Test
    @DisplayName("Method description: ...")
    public void testGetAppInfoByMap() throws Exception {
        Map<String,Object> map = null;
        Label<?> label = new ClusterLabel();
        List<Label<?>> labels = null;
        RMLabelContainer rMLabelContainer = new RMLabelContainer(labels);
//        externalResourceServiceImpl.getAppInfo(ResourceType.Yarn,rMLabelContainer, map);
    }

    @Test
    @DisplayName("Method description: ...")
    public void testGetAppInfoByIdentifier() throws Exception {
//        externalResourceServiceImpl.getAppInfo(ResourceType.Yarn,);
    }
} 
