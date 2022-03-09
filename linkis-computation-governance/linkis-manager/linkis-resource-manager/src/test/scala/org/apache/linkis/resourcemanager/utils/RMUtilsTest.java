package org.apache.linkis.resourcemanager.utils;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.linkis.manager.common.entity.persistence.PersistenceResource;
import org.apache.linkis.manager.common.entity.resource.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class RMUtilsTest {
    @BeforeEach
    @DisplayName("Each unit test method is executed once before execution")
    protected void beforeEach() throws Exception {
    }

    @AfterEach
    @DisplayName("Each unit test method is executed once after execution")
    protected void afterEach() throws Exception {}


    @Test
    public void testConstant() {
        assertEquals(RMUtils.EXTERNAL_RESOURCE_REFRESH_TIME().key(),"wds.linkis.manager.rm.external.resource.regresh.time");
    }

    @Test
    public void testDeserializeResource(){
        NodeResource nodeResource = new CommonNodeResource();
        nodeResource.setResourceType(ResourceType.Yarn);
        PersistenceResource persistenceResource = RMUtils.toPersistenceResource(nodeResource);
        assertEquals(0,persistenceResource.getId());
    }

    @Test
    public void testAggregateNodeResource(){
        NodeResource firstNodeResource = new CommonNodeResource();
        NodeResource secondNodeResource = new CommonNodeResource();
        CommonNodeResource commonNodeResource = RMUtils.aggregateNodeResource(firstNodeResource,secondNodeResource);
        assertEquals(null,commonNodeResource.getResourceType());
    }

    @Test
    public void testAggregateResource(){
        Resource firstResource = new YarnResource(50L,8,2,null,null);
        Resource secondResource = new YarnResource(30L,6,2,null,null);
        Resource resource = RMUtils.aggregateResource(firstResource,secondResource);
        assertNotEquals(null,resource);
    }
}
