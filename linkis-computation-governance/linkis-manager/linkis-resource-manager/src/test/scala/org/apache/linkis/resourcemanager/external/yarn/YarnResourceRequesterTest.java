package org.apache.linkis.resourcemanager.external.yarn;

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

import org.apache.linkis.manager.common.entity.resource.NodeResource;
import org.apache.linkis.manager.common.entity.resource.ResourceType;
import org.apache.linkis.manager.common.entity.resource.YarnResource;
import org.apache.linkis.resourcemanager.external.domain.ExternalResourceIdentifier;
import org.apache.linkis.resourcemanager.external.domain.ExternalResourceProvider;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class YarnResourceRequesterTest {
    YarnResourceRequester yarnResourceRequester = new YarnResourceRequester();
    ExternalResourceProvider externalResourceProvider = new ExternalResourceProvider();
    @BeforeEach
    @DisplayName("Each unit test method is executed once before execution")
    protected void beforeEach() throws Exception {
        String config = "{\r\n\"rmWebAddress\": \"@YARN_RESTFUL_URL\",\r\n\"hadoopVersion\": \"2.7.2\",\r\n\"authorEnable\":false,\r\n\"user\":\"hadoop\",\r\n\"pwd\":\"123456\",\r\n\"kerberosEnable\":@KERBEROS_ENABLE,\r\n\"principalName\":\"@PRINCIPAL_NAME\",\r\n\"keytabPath\":\"@KEYTAB_PATH\",\r\n\"krb5Path\":\"@KRB5_PATH\"\r\n}";
        externalResourceProvider.setConfig(config);
    }

    @AfterEach
    @DisplayName("Each unit test method is executed once after execution")
    protected void afterEach() throws Exception {}

    @Test
    public void testRequestResourceInfo(){
        NodeResource nodeResource = yarnResourceRequester.requestResourceInfo(new YarnResourceIdentifier("yarn"),externalResourceProvider);
        assertNotEquals(null,nodeResource);
    }

    @Test
    public void testRequestAppInfo() {
        yarnResourceRequester.requestAppInfo(new YarnResourceIdentifier("yarn"),externalResourceProvider);
    }

    @Test
    public void testAddShutdownHook() {
        yarnResourceRequester.addShutdownHook();
    }
}
