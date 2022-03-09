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

import org.apache.linkis.manager.common.entity.persistence.PersistenceLabel;
import org.apache.linkis.manager.common.entity.persistence.PersistenceResource;
import org.apache.linkis.manager.common.entity.resource.CommonNodeResource;
import org.apache.linkis.manager.common.entity.resource.NodeResource;
import org.apache.linkis.manager.label.entity.Label;
import org.apache.linkis.manager.label.entity.em.EMInstanceLabel;
import org.apache.linkis.manager.label.service.ResourceLabelService;
import org.apache.linkis.manager.persistence.LabelManagerPersistence;
import org.apache.linkis.manager.persistence.ResourceManagerPersistence;
import org.apache.linkis.resourcemanager.domain.RMLabelContainer;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class LabelResourceServiceImplTest {

    @InjectMocks
    private LabelResourceServiceImpl labelResourceServiceImpl;

    @Mock
    private ResourceManagerPersistence resourceManagerPersistence;

    @Mock
    private LabelManagerPersistence labelManagerPersistence;

    @Mock
    private ResourceLabelService resourceLabelService;

    @BeforeEach
    @DisplayName("Each unit test method is executed once before execution")
    protected void beforeEach() throws Exception {

    }

    @AfterEach
    @DisplayName("Each unit test method is executed once after execution")
    protected void afterEach() throws Exception {

    }

    @Test
    public void testGetLabelResource(){
        Label label = new PersistenceLabel();
        labelResourceServiceImpl.getLabelResource(label);
    }

    @Test
    public void testSetLabelResource(){
        Label label = new PersistenceLabel();
        NodeResource nodeResource = new CommonNodeResource();
        labelResourceServiceImpl.setLabelResource(label,nodeResource,null);
    }

    @Test
    public void testGetResourcesByUser(){
        labelResourceServiceImpl.getResourcesByUser("hadoop");
    }

    @Test
    public void testRemoveResourceByLabel(){
        Label label = new PersistenceLabel();
        labelResourceServiceImpl.removeResourceByLabel(label);
    }

    @Test
    public void testSetEngineConnLabelResource(){
        Label label = new PersistenceLabel();
        NodeResource nodeResource = new CommonNodeResource();
        labelResourceServiceImpl.setEngineConnLabelResource(label,nodeResource,null);
    }

    @Test
    public void testGetLabelsByResource(){
        PersistenceResource resource = new PersistenceResource();
        labelResourceServiceImpl.getLabelsByResource(resource);
    }
}
