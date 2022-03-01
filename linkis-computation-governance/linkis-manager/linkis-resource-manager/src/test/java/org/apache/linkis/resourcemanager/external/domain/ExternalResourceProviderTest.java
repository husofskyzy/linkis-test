package org.apache.linkis.resourcemanager.external.domain;

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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

/**
 * ExternalResourceProvider Tester
 */
public class ExternalResourceProviderTest {

    @BeforeAll
    protected static void beforeAll() throws Exception {
    }

    @AfterAll
    protected static void afterAll() throws Exception {
    }

    @Test
    @DisplayName("Method description: ...")
    public void testGetConfigMap() throws Exception {
        String config = "{\r\n\"rmWebAddress\": \"@YARN_RESTFUL_URL\",\r\n\"hadoopVersion\": \"2.7.2\",\r\n\"authorEnable\":false,\r\n\"user\":\"hadoop\",\r\n\"pwd\":\"123456\",\r\n\"kerberosEnable\":@KERBEROS_ENABLE,\r\n\"principalName\":\"@PRINCIPAL_NAME\",\r\n\"keytabPath\":\"@KEYTAB_PATH\",\r\n\"krb5Path\":\"@KRB5_PATH\"\r\n}";
        ExternalResourceProvider externalResourceProvider = new ExternalResourceProvider();
        externalResourceProvider.config = config;
        assertNotEquals(0, externalResourceProvider.getConfigMap().size());
        assertEquals("2.7.2",externalResourceProvider.getConfigMap().get("hadoopVersion"));

    }
} 
