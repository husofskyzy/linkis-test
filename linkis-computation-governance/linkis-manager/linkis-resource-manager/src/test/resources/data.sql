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

DELETE FROM linkis_cg_rm_external_resource_provider;

insert  into linkis_cg_rm_external_resource_provider(`id`,`resource_type`,`name`,`labels`,`config`) values
(1,'Yarn','sit',NULL,'{\r\n\"rmWebAddress\": \"@YARN_RESTFUL_URL\",\r\n\"hadoopVersion\": \"2.7.2\",\r\n\"authorEnable\":false,\r\n\"user\":\"hadoop\",\r\n\"pwd\":\"123456\",\r\n\"kerberosEnable\":@KERBEROS_ENABLE,\r\n\"principalName\":\"@PRINCIPAL_NAME\",\r\n\"keytabPath\":\"@KEYTAB_PATH\",\r\n\"krb5Path\":\"@KRB5_PATH\"\r\n}'),
(2,'Yarn2','sit2',NULL,'{\r\n\"rmWebAddress\": \"@YARN_RESTFUL_URL\",\r\n\"hadoopVersion\": \"2.7.2\",\r\n\"authorEnable\":false,\r\n\"user\":\"hadoop\",\r\n\"pwd\":\"123456\",\r\n\"kerberosEnable\":@KERBEROS_ENABLE,\r\n\"principalName\":\"@PRINCIPAL_NAME\",\r\n\"keytabPath\":\"@KEYTAB_PATH\",\r\n\"krb5Path\":\"@KRB5_PATH\"\r\n}'),
(3,'Yarn3','sit3',NULL,'{\r\n\"rmWebAddress\": \"@YARN_RESTFUL_URL\",\r\n\"hadoopVersion\": \"2.7.2\",\r\n\"authorEnable\":false,\r\n\"user\":\"hadoop\",\r\n\"pwd\":\"123456\",\r\n\"kerberosEnable\":@KERBEROS_ENABLE,\r\n\"principalName\":\"@PRINCIPAL_NAME\",\r\n\"keytabPath\":\"@KEYTAB_PATH\",\r\n\"krb5Path\":\"@KRB5_PATH\"\r\n}');