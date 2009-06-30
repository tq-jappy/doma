/*
 * Copyright 2004-2009 the Seasar Foundation and the Others.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.seasar.doma.domain;

import org.seasar.doma.domain.IntegerDomain;

import junit.framework.TestCase;

/**
 * @author taedium
 * 
 */
public class IntegerDomainTest extends TestCase {

    public void testEquals() throws Exception {
        IntegerDomain domain = new IntegerDomain(1);
        IntegerDomain domain2 = new IntegerDomain(1);
        assertTrue(domain.equals(domain2));

        domain.setNull();
        assertFalse(domain.equals(domain2));

        domain2.setNull();
        assertTrue(domain.equals(domain2));

        domain.set(1);
        assertFalse(domain.equals(domain2));

    }
}
