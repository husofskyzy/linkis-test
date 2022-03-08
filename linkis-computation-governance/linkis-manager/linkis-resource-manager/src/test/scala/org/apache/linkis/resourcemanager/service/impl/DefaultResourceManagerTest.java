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
import org.apache.linkis.manager.common.entity.resource.CommonNodeResource;
import org.apache.linkis.manager.common.entity.resource.NodeResource;
import org.apache.linkis.manager.common.entity.resource.ResourceType;
import org.apache.linkis.manager.common.protocol.em.EMInfoClearRequest;
import org.apache.linkis.manager.engineplugin.common.resource.UserNodeResource;
import org.apache.linkis.manager.label.entity.Label;
import org.apache.linkis.manager.label.entity.entrance.BindEngineLabel;
import org.apache.linkis.manager.label.service.NodeLabelService;
import org.apache.linkis.manager.persistence.LabelManagerPersistence;
import org.apache.linkis.manager.persistence.NodeManagerPersistence;
import org.apache.linkis.manager.persistence.NodeMetricManagerPersistence;
import org.apache.linkis.manager.persistence.ResourceManagerPersistence;
import org.apache.linkis.message.builder.DefaultServiceMethodContext;
import org.apache.linkis.message.builder.ServiceMethodContext;
import org.apache.linkis.resourcemanager.domain.RMLabelContainer;
import org.apache.linkis.resourcemanager.external.service.ExternalResourceService;
import org.apache.linkis.resourcemanager.service.LabelResourceService;
import org.apache.linkis.resourcemanager.service.ResourceLockService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class DefaultResourceManagerTest {
    @InjectMocks
    private DefaultResourceManager defaultResourceManager;

    @Mock
    private ResourceManagerPersistence resourceManagerPersistence;

    @Mock
    private NodeManagerPersistence nodeManagerPersistence;

    @Mock
    private ResourceLockService resourceLockService;

    @Mock
    private LabelResourceService labelResourceService;

    @Mock
    private ExternalResourceService externalResourceService;

    @Mock
    private ResourceLogService resourceLogService;

    @Mock
    private LabelManagerPersistence labelManagerPersistence;

    @Mock
    private NodeMetricManagerPersistence nodeMetricManagerPersistence;

    @Mock
    private NodeLabelService nodeLabelService;

    @BeforeEach
    @DisplayName("Each unit test method is executed once before execution")
    protected void beforeEach() throws Exception {
    }

    @AfterEach
    @DisplayName("Each unit test method is executed once after execution")
    protected void afterEach() throws Exception {}

    @Test
    public void testRegister(){
        ServiceInstance serviceInstance = new ServiceInstance();
        NodeResource nodeResource = new CommonNodeResource();
        defaultResourceManager.register(serviceInstance,nodeResource);
    }

    @Test
    public void testUnregister(){
        ServiceInstance serviceInstance = new ServiceInstance();
        defaultResourceManager.unregister(serviceInstance);
    }

    @Test
    public void testRequestResource(){
        NodeResource nodeResource = new CommonNodeResource();
        List<Label<?>> labels = new ArrayList<Label<?>>();
        Label label = new BindEngineLabel();
        labels.add(label);
        defaultResourceManager.requestResource(labels,nodeResource);
    }

    @Test
    public void testRequestResourceAndWait(){
        NodeResource nodeResource = new CommonNodeResource();
        List<Label<?>> labels = new ArrayList<Label<?>>();
        Label label = new BindEngineLabel();
        labels.add(label);
        defaultResourceManager.requestResource(labels,nodeResource,100);
    }

    @Test
    public void testResourceCheck(){
        NodeResource nodeResource = new CommonNodeResource();
        Label label = new BindEngineLabel();
        defaultResourceManager.resourceCheck(label,nodeResource);
    }

    @Test
    public void testResourceUsed(){
        NodeResource nodeResource = new CommonNodeResource();
        List<Label<?>> labels = new ArrayList<Label<?>>();
        Label label = new BindEngineLabel();
        labels.add(label);
        defaultResourceManager.resourceUsed(labels,nodeResource);
    }

    @Test
    public void testTimeCheck(){
        NodeResource nodeResource = new CommonNodeResource();
        NodeResource userResource = new UserNodeResource();
        defaultResourceManager.timeCheck(nodeResource,userResource);
    }

    @Test
    public void testResourceReleased(){
        ServiceInstance serviceInstance = new ServiceInstance();
        NodeResource nodeResource = new CommonNodeResource();
        defaultResourceManager.register(serviceInstance,nodeResource);
    }

    @Test
    public void testGetResourceInfo(){
        ServiceInstance serviceInstance1 = new ServiceInstance();
        ServiceInstance serviceInstance2 = new ServiceInstance();
        ServiceInstance[] serviceInstances = {serviceInstance1,serviceInstance2};
        defaultResourceManager.getResourceInfo(serviceInstances);
    }

    @Test
    public void testGetRequestResourceService(){
        defaultResourceManager.getRequestResourceService(ResourceType.Yarn);
    }
}
