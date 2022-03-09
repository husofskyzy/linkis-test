package org.apache.linkis.resourcemanager.message;

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
import org.apache.linkis.manager.common.entity.node.AMEMNode;
import org.apache.linkis.manager.common.entity.node.AMEngineNode;
import org.apache.linkis.manager.common.entity.node.EMNode;
import org.apache.linkis.manager.common.entity.node.EngineNode;
import org.apache.linkis.manager.common.entity.resource.CommonNodeResource;
import org.apache.linkis.manager.common.entity.resource.NodeResource;
import org.apache.linkis.manager.common.protocol.em.EMInfoClearRequest;
import org.apache.linkis.manager.common.protocol.em.EMResourceRegisterRequest;
import org.apache.linkis.manager.common.protocol.em.StopEMRequest;
import org.apache.linkis.manager.common.protocol.engine.EngineInfoClearRequest;
import org.apache.linkis.manager.common.protocol.node.NodeHeartbeatMsg;
import org.apache.linkis.manager.common.protocol.resource.ResourceUsedProtocol;
import org.apache.linkis.manager.engineplugin.common.resource.UserNodeResource;
import org.apache.linkis.manager.label.service.NodeLabelAddService;
import org.apache.linkis.manager.label.service.NodeLabelService;
import org.apache.linkis.manager.service.common.label.ManagerLabelService;
import org.apache.linkis.message.builder.DefaultServiceMethodContext;
import org.apache.linkis.message.builder.ServiceMethodContext;
import org.apache.linkis.resourcemanager.external.yarn.YarnResourceIdentifier;
import org.apache.linkis.resourcemanager.service.ResourceManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class RMMessageServiceTest {
    @InjectMocks
    private RMMessageService rMMessageService;

    @Mock
    private ResourceManager resourceManager;

    @Mock
    private NodeLabelService nodeLabelService;

    @Mock
    private ManagerLabelService managerLabelService;

    @BeforeEach
    @DisplayName("Each unit test method is executed once before execution")
    protected void beforeEach() throws Exception {
    }

    @AfterEach
    @DisplayName("Each unit test method is executed once after execution")
    protected void afterEach() throws Exception {}

    @Test
    public void testDealWithEMInfoClearRequest(){
        EMNode node = new AMEMNode();
        ServiceMethodContext serviceMethodContext = new DefaultServiceMethodContext();
        EMInfoClearRequest eMInfoClearRequest = new EMInfoClearRequest();
        eMInfoClearRequest.setEm(node);
        rMMessageService.dealWithEMInfoClearRequest(eMInfoClearRequest,serviceMethodContext);
    }

    @Test
    public void testDealWithEngineInfoClearRequest(){
        EngineNode engineNode = new AMEngineNode();
        EngineInfoClearRequest engineInfoClearRequest = new EngineInfoClearRequest();
        engineInfoClearRequest.setEngineNode(engineNode);
        ServiceMethodContext serviceMethodContext = new DefaultServiceMethodContext();
        rMMessageService.dealWithEngineInfoClearRequest(engineInfoClearRequest,serviceMethodContext);
    }

    @Test
    public void testDealWithNodeHeartbeatMsg(){
        NodeHeartbeatMsg nodeHeartbeatMsg = new NodeHeartbeatMsg();
        ServiceMethodContext serviceMethodContext = new DefaultServiceMethodContext();
        rMMessageService.dealWithNodeHeartbeatMsg(nodeHeartbeatMsg,serviceMethodContext);
    }

    @Test
    public void testDealWithResourceUsedProtocol(){
        NodeResource nodeResource = new UserNodeResource();
        ServiceInstance serviceInstance = new ServiceInstance();
        serviceInstance.setInstance("instance");
        serviceInstance.setApplicationName("app");
        ResourceUsedProtocol resourceUsedProtocol = new ResourceUsedProtocol(serviceInstance,nodeResource,"appId");
        rMMessageService.dealWithResourceUsedProtocol(resourceUsedProtocol);
    }

    @Test
    public void testDealWithRegisterEMRequest(){
        EMResourceRegisterRequest eMResourceRegisterRequest = new EMResourceRegisterRequest();
        rMMessageService.dealWithRegisterEMRequest(eMResourceRegisterRequest);
    }

    @Test
    public void testDealWithStopEMRequest(){
        StopEMRequest stopEMRequest = new StopEMRequest();
        rMMessageService.dealWithStopEMRequest(stopEMRequest);
    }
}
