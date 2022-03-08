package org.apache.linkis.resourcemanager.utils;

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

import org.apache.linkis.manager.common.entity.resource.Resource;
import org.apache.linkis.manager.common.entity.resource.ResourceType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class UserConfigurationTest {
    @BeforeEach
    @DisplayName("Each unit test method is executed once before execution")
    protected void beforeEach() throws Exception {
    }

    @AfterEach
    @DisplayName("Each unit test method is executed once after execution")
    protected void afterEach() throws Exception {}

    @Test
    public void testGenerateResource() {
        Map<String,String> map = new HashMap<String,String>();
        map.put("key","val");
        Resource resource = UserConfiguration.generateResource(ResourceType.Yarn,map);
        assertNotEquals(null,resource);
    }
}
