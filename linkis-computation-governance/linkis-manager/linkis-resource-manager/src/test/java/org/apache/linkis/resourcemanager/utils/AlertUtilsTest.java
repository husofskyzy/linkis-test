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

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/** 
 * AlertUtils Tester
*/ 
public class AlertUtilsTest {
    @BeforeAll
    @DisplayName("Each unit test method is executed once before execution")
    protected static void beforeAll() throws Exception {
    }

    @AfterAll
    @DisplayName("Each unit test method is executed once after execution")
    protected static void afterAll() throws Exception {}
 
    @Test
    @DisplayName("Method description: ...")
    public void testSendAlertAsync() throws Exception {
        AlertUtils.sendAlertAsync("title1","info1");
    }

    @Test
    @DisplayName("Method description: ...")
    public void testGetContactByQueue() throws Exception {
        AlertUtils.getContactByQueue("queue1");
    }
 
}
