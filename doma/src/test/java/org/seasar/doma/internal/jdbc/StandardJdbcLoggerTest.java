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
package org.seasar.doma.internal.jdbc;

import java.util.Collections;

import org.seasar.doma.internal.jdbc.sql.PreparedSql;
import org.seasar.doma.internal.jdbc.sql.PreparedSqlParameter;
import org.seasar.doma.jdbc.StandardJdbcLogger;

import junit.framework.TestCase;

/**
 * @author taedium
 * 
 */
public class StandardJdbcLoggerTest extends TestCase {

    public void test() throws Exception {
        PreparedSql sql = new PreparedSql("aaa", "bbb", Collections
                .<PreparedSqlParameter> emptyList());
        StandardJdbcLogger logger = new StandardJdbcLogger();
        logger.logSql("ccc", "ddd", sql);
    }
}
