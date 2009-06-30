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
package org.seasar.doma.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author taedium
 * 
 */
public interface Dialect {

    String getName();

    SqlNode transformSelectSqlNode(SqlNode original, SelectOptions options);

    boolean isUniqueConstraintViolated(SQLException sqlException);

    boolean includesIdentityColumn();

    boolean supportsIdentity();

    boolean supportsSequence();

    boolean supportsAutoGeneratedKeys();

    boolean supportsBatchUpdateResults();

    boolean supportsSelectForUpdate(SelectForUpdateType type,
            boolean withTargets);

    boolean supportsResultSetReturningAsOutParameter();

    Sql<?> getIdentitySelectSql(String qualifiedTableName, String columnName);

    Sql<?> getSequenceNextValSql(String qualifiedSequenceName,
            long allocationSize);

    JdbcType<ResultSet> getResultSetType();

    String applyQuote(String name);

    String removeQuote(String name);

}
