package org.apache.linkis.resourcemanager.service.impl;

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

import org.apache.linkis.common.ServiceInstance;
import org.apache.linkis.manager.common.entity.persistence.PersistenceLabel;
import org.apache.linkis.manager.common.entity.resource.CommonNodeResource;
import org.apache.linkis.manager.common.entity.resource.NodeResource;
import org.apache.linkis.manager.common.entity.resource.Resource;
import org.apache.linkis.manager.common.entity.resource.YarnResource;
import org.apache.linkis.manager.label.entity.Label;
import org.apache.linkis.manager.label.entity.em.EMInstanceLabel;
import org.apache.linkis.manager.label.service.ResourceLabelService;
import org.apache.linkis.resourcemanager.domain.RMLabelContainer;
import org.apache.linkis.resourcemanager.external.service.ExternalResourceService;
import org.apache.linkis.resourcemanager.external.service.ExternalResourceServiceImpl;
import org.apache.linkis.resourcemanager.service.LabelResourceService;
import org.apache.linkis.resourcemanager.utils.RMUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class DriverAndYarnReqResourceServiceTest {
    @MockBean
    private ResourceLabelService resourceLabelService;

    LabelResourceService labelResourceService = new LabelResourceServiceImpl();
    ExternalResourceService externalResourceService = new ExternalResourceServiceImpl();
    DriverAndYarnReqResourceService driverAndYarnReqResourceService = new DriverAndYarnReqResourceService(labelResourceService,externalResourceService);

    @BeforeEach
    @DisplayName("Each unit test method is executed once before execution")
    protected void beforeEach() throws Exception {

    }

    @AfterEach
    @DisplayName("Each unit test method is executed once after execution")
    protected void afterEach() throws Exception {

    }

    @Test
    public void testCanRequest(){
        NodeResource nodeResource = new CommonNodeResource();
        List<Label<?>> labels = new ArrayList<>();
        Label<?> label = new EMInstanceLabel();
        labels.add(label);
        labelResourceService.setLabelResource(label,nodeResource,"app");
        RMLabelContainer rMLabelContainer = new RMLabelContainer(labels);
        driverAndYarnReqResourceService.canRequest(rMLabelContainer,nodeResource);
    }

    @Test
    public void testGenerateQueueNotEnoughMessage(){
        Resource requestResource = new YarnResource(50L,8,2,"queueName1","app1");
        Resource availableResource = new YarnResource(500L,10,6,"queueName2","app2");
        driverAndYarnReqResourceService.generateQueueNotEnoughMessage(requestResource,availableResource);
    }
}
