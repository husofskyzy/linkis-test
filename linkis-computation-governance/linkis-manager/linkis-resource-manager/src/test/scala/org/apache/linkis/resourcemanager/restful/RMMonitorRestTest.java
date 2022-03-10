package org.apache.linkis.resourcemanager.restful;

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

import org.apache.linkis.common.utils.JsonUtils;
import org.apache.linkis.manager.label.service.NodeLabelService;
import org.apache.linkis.manager.persistence.LabelManagerPersistence;
import org.apache.linkis.manager.persistence.NodeManagerPersistence;
import org.apache.linkis.manager.persistence.NodeMetricManagerPersistence;
import org.apache.linkis.manager.persistence.ResourceManagerPersistence;
import org.apache.linkis.manager.service.common.label.ManagerLabelService;
import org.apache.linkis.manager.service.common.metrics.MetricsConverter;
import org.apache.linkis.resourcemanager.Scan;
import org.apache.linkis.resourcemanager.WebApplicationServer;
import org.apache.linkis.resourcemanager.external.service.ExternalResourceService;
import org.apache.linkis.resourcemanager.message.RMMessageService;
import org.apache.linkis.resourcemanager.service.LabelResourceService;
import org.apache.linkis.resourcemanager.service.ResourceManager;
import org.apache.linkis.server.Message;
import org.apache.linkis.server.MessageStatus;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {WebApplicationServer.class, Scan.class})
@AutoConfigureMockMvc
public class RMMonitorRestTest {
    @MockBean(name = "rMMessageService")
    private RMMessageService rMMessageService;

    @MockBean(name = "labelManagerPersistence")
    private LabelManagerPersistence  labelManagerPersistence;

    @MockBean(name = "nodeLabelService")
    private NodeLabelService  nodeLabelService;

    @MockBean(name = "resourceManagerPersistence")
    private ResourceManagerPersistence  resourceManagerPersistence;

    @MockBean(name = "nodeManagerPersistence")
    private NodeManagerPersistence  nodeManagerPersistence;

    @MockBean(name = "nodeMetricManagerPersistence")
    private NodeMetricManagerPersistence  nodeMetricManagerPersistence;

    @MockBean(name = "metricsConverter")
    private MetricsConverter metricsConverter;

    @MockBean(name = "externalResourceService")
    private ExternalResourceService  externalResourceService;

    @MockBean(name = "labelResourceService")
    private LabelResourceService  labelResourceService;

    @MockBean(name = "defaultResourceManager")
    private ResourceManager resourceManager;

    @MockBean(name = "defaultManagerLabelService")
    private ManagerLabelService managerLabelService;

    private static final Logger logger = LoggerFactory.getLogger(RMMonitorRestTest.class);

    @MockBean(name = "jobDetailMapper")
    protected MockMvc mockMvc;

    @BeforeAll
    @DisplayName("Each unit test method is executed once before execution")
    protected static void beforeAll() throws Exception {
    }

    @AfterAll
    @DisplayName("Each unit test method is executed once before execution")
    protected static void afterAll() {}

    @Test
    public void testGetApplicationList() throws Exception {
        MultiValueMap<String, String> paramsMap = new LinkedMultiValueMap<>();
        paramsMap.add("name","tom");

        MvcResult mvcResult =
                mockMvc.perform(post("/linkisManager/rm/applicationlist").params(paramsMap))
                        .andExpect(status().isOk())
                        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                        .andReturn();

        //json返回值转对象
        Message res =
                JsonUtils.jackson()
                        .readValue(mvcResult.getResponse().getContentAsString(), Message.class);
        //比较返回值状态是否成功
        assertEquals(MessageStatus.SUCCESS(), res.getStatus());
        //日志查看返回值
        logger.info(mvcResult.getResponse().getContentAsString());
    }
    @Test
    public void testGetUserResource(){

    }
    @Test
    public void testGetEngines(){

    }
    @Test
    public void testGetQueueResource(){

    }
    @Test
    public void testGetQueues(){

    }
}
