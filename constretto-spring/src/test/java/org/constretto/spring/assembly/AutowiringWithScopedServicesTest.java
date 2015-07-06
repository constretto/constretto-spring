/*
 * Copyright 2008 the original author or authors. Licensed under the Apache
 * License, Version 2.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law
 * or agreed to in writing, software distributed under the License is
 * distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.constretto.spring.assembly;

import static org.constretto.spring.annotation.Environment.DEVELOPMENT;
import org.constretto.spring.assembly.helper.ConfigurationService;
import static org.constretto.spring.internal.resolver.DefaultAssemblyContextResolver.ASSEMBLY_KEY;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author <a href="mailto:kaare.nilsen@gmail.com">Kaare Nilsen</a>
 */
public class AutowiringWithScopedServicesTest {
    ConfigurationService configurationService;

    @Before
    public void removeAssemblyKey() {
        System.clearProperty(ASSEMBLY_KEY);
    }

    @Test
    public void givenAssemblyContextWhenScopedClassAnnotatedWithEnvironment() {
        System.setProperty(ASSEMBLY_KEY, DEVELOPMENT);
        loadContextAndInjectConfigurationService();
        assertEquals(DEVELOPMENT, configurationService.getRunningEnvironment());
    }

    private void loadContextAndInjectConfigurationService() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "org/constretto/spring/assembly/AutowiringWithScopedServicesTest-context.xml");
        configurationService = (ConfigurationService) ctx.getBean("configurationService");
    }
}
