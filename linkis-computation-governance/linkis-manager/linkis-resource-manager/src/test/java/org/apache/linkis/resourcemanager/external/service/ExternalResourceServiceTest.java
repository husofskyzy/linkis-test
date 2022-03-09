//package org.apache.linkis.resourcemanager.external.service;
//
///*
// * Licensed to the Apache Software Foundation (ASF) under one or more
// * contributor license agreements.  See the NOTICE file distributed with
// * this work for additional information regarding copyright ownership.
// * The ASF licenses this file to You under the Apache License, Version 2.0
// * (the "License"); you may not use this file except in compliance with
// * the License.  You may obtain a copy of the License at
// *
// *    http://www.apache.org/licenses/LICENSE-2.0
// *
// * Unless required by applicable law or agreed to in writing, software
// * distributed under the License is distributed on an "AS IS" BASIS,
// * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// * See the License for the specific language governing permissions and
// * limitations under the License.
// */
//
//import org.apache.linkis.manager.common.entity.resource.ResourceType;
//import org.apache.linkis.resourcemanager.domain.RMLabelContainer;
//import org.apache.linkis.resourcemanager.exception.RMErrorException;
//import org.apache.linkis.resourcemanager.external.dao.ExternalResourceProviderDao;
//import org.apache.linkis.resourcemanager.external.domain.ExternalResourceProvider;
//import org.apache.linkis.resourcemanager.external.yarn.YarnResourceIdentifier;
//import org.h2.tools.Server;
//import org.junit.jupiter.api.AfterAll;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.mockito.Mockito.lenient;
//
///**
// * ExternalResourceServiceImpl Tester
// */
//@ExtendWith(MockitoExtension.class)
////@RunWith(SpringJUnit4ClassRunner.class)
//public class ExternalResourceServiceTest {
//
//    @InjectMocks
//    private ExternalResourceServiceImpl externalResourceService;
//
//    @Mock
//    private ExternalResourceProviderDao externalResourceProviderDao;
//
//
//    private ExternalResourceProvider createOne() {
//        ExternalResourceProvider provider = new ExternalResourceProvider();
//
//        provider.setId(0);
//        provider.setResourceType(ResourceType.Yarn.toString());
//        provider.setName("sit");
//        provider.setLabels("test");
//        return provider;
//    }
//
//    @BeforeAll
//    protected static void beforeAll() throws Exception {
//        System.out.println("xxx");
//        Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8082").start();
//    }
//
//    @AfterAll
//    protected static void afterAll() throws Exception {
//        for (; ; ) {
//        }
//    }
//
//
//    @Test
//    public void testGetResourceByMap() throws Exception {
//        //do afterPropertiesSet manually
//        externalResourceService.afterPropertiesSet();
//
//        RMLabelContainer labelContainer = new RMLabelContainer(new ArrayList());
//
//        List<ExternalResourceProvider> list = new ArrayList<>();
//        list.add(createOne());
//
//        lenient().when(externalResourceProviderDao.selectByResourceType("Yarn")).thenReturn(list);
//        Map<String, Object> identifierMap = new HashMap<>();
//        identifierMap.put("queueName", "dws");
//
////        YarnResourceRequester externalResourceRequester = Mockito.mock(YarnResourceRequester.class);
////
////        List<ExternalAppInfo> externalAppInfos=new ArrayList<ExternalAppInfo>();
////        externalAppInfos.add(new YarnAppInfo(null,null,null,null,null));
////        Mockito.when(externalResourceRequester.requestAppInfo(any(ExternalResourceIdentifier.class),any(ExternalResourceProvider.class)))
////                .thenReturn(externalAppInfos);
//        Exception exception = assertThrows(RMErrorException.class, () -> externalResourceService.getResource(ResourceType.Yarn, labelContainer, identifierMap));
//
//
//    }
//
//    @Test
//    public void testGetResourceByIdentifier() throws Exception {
//        //do afterPropertiesSet manually
//        externalResourceService.afterPropertiesSet();
//
//        YarnResourceIdentifier yarnIdentifier = new YarnResourceIdentifier("dws");
//        RMLabelContainer labelContainer = new RMLabelContainer(new ArrayList());
//
//        List<ExternalResourceProvider> list = new ArrayList<>();
//        list.add(createOne());
//
//        lenient().when(externalResourceProviderDao.selectByResourceType("Yarn")).thenReturn(list);
//
//        Exception exception = assertThrows(RMErrorException.class, () -> externalResourceService.getResource(ResourceType.Yarn, labelContainer, yarnIdentifier));
//
//    }
//
//    @Test
//    public void testGetAppInfoByMap() throws Exception {
//        //do afterPropertiesSet manually
//        externalResourceService.afterPropertiesSet();
//
//        YarnResourceIdentifier yarnIdentifier = new YarnResourceIdentifier("dws");
//        RMLabelContainer labelContainer = new RMLabelContainer(new ArrayList());
//
//        List<ExternalResourceProvider> list = new ArrayList<>();
//        list.add(createOne());
//
//        lenient().when(externalResourceProviderDao.selectByResourceType("Yarn")).thenReturn(list);
//        Map<String, Object> identifierMap = new HashMap<>();
//        identifierMap.put("queueName", "test");
//
//        Exception exception = assertThrows(RMErrorException.class, () -> externalResourceService.getAppInfo(ResourceType.Yarn, labelContainer, identifierMap));
//    }
//
//    @Test
//    public void testGetAppInfoByIdentifier() throws Exception {
//        //do afterPropertiesSet manually
//        externalResourceService.afterPropertiesSet();
//
//        YarnResourceIdentifier yarnIdentifier = new YarnResourceIdentifier("dws");
//        RMLabelContainer labelContainer = new RMLabelContainer(new ArrayList());
//        List<ExternalResourceProvider> list = new ArrayList<>();
//        list.add(createOne());
//        lenient().when(externalResourceProviderDao.selectByResourceType("Yarn")).thenReturn(list);
//        Exception exception = assertThrows(RMErrorException.class, () -> externalResourceService.getAppInfo(ResourceType.Yarn, labelContainer, yarnIdentifier));
//    }
//}
