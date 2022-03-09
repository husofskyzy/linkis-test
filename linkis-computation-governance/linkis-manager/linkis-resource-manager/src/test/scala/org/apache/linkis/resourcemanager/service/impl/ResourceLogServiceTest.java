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
import org.apache.linkis.manager.label.entity.Label;
import org.apache.linkis.resourcemanager.service.LabelResourceService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ResourceLogServiceTest {

    @InjectMocks
    private ResourceLogService resourceLogService;

    @Mock
    private LabelResourceService labelResourceService;

    @BeforeEach
    @DisplayName("Each unit test method is executed once before execution")
    protected void beforeEach() throws Exception {

    }

    @AfterEach
    @DisplayName("Each unit test method is executed once after execution")
    protected void afterEach() throws Exception {

    }

    @Test
    public void testFailed(){
        Label label = new PersistenceLabel();
//        resourceLogService.failed();
    }

    @Test
    public void testSuccess(){
        Label label = new PersistenceLabel();
//        resourceLogService.success();
    }

    @Test
    public void testPrintUsedResourceNode(){
        Label label = new PersistenceLabel();
//        resourceLogService.printUsedResourceNode();
    }

    @Test
    public void testPrintReleaseResourceNode(){
        Label label = new PersistenceLabel();
//        resourceLogService.printReleaseResourceNode();
    }

    @Test
    public void testPrintNode(){
        Label label = new PersistenceLabel();
//        resourceLogService.printNode();
    }
}
