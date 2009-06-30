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
package org.seasar.doma.jdbc.dialect;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.seasar.doma.DomaIllegalArgumentException;
import org.seasar.doma.DomaUnsupportedOperationException;
import org.seasar.doma.internal.jdbc.dialect.StandardForUpdateTransformer;
import org.seasar.doma.internal.jdbc.dialect.StandardPagingTransformer;
import org.seasar.doma.internal.jdbc.sql.PreparedSql;
import org.seasar.doma.jdbc.Dialect;
import org.seasar.doma.jdbc.JdbcException;
import org.seasar.doma.jdbc.JdbcType;
import org.seasar.doma.jdbc.SelectForUpdateType;
import org.seasar.doma.jdbc.SelectOptions;
import org.seasar.doma.jdbc.SqlNode;
import org.seasar.doma.message.MessageCode;


/**
 * @author taedium
 * 
 */
public class StandardDialect implements Dialect {

    protected static final char OPEN_QUOTE = '"';

    protected static final char CLOSE_QUOTE = '"';

    protected static final Set<String> UNIQUE_CONSTRAINT_VIOLATION_STATE_CODES = new HashSet<String>(
            Arrays.asList("23", "27", "44"));

    @Override
    public String getName() {
        return "standard";
    }

    @Override
    public SqlNode transformSelectSqlNode(SqlNode original,
            SelectOptions options) {
        if (original == null) {
            throw new DomaIllegalArgumentException("original", original);
        }
        if (options == null) {
            throw new DomaIllegalArgumentException("options", options);
        }
        SqlNode transformed = original;
        if (options.getOffset() >= 0 || options.getLimit() >= 0) {
            transformed = toPagingSqlNode(transformed, options.getOffset(), options
                    .getLimit());
        }
        if (options.getForUpdateType() != null) {
            SelectForUpdateType forUpdateType = options.getForUpdateType();
            String[] aliases = options.getAliases();
            if (!supportsSelectForUpdate(forUpdateType, false)) {
                throw new JdbcException(MessageCode.DOMA2023, getName());
            }
            if (aliases.length > 0) {
                if (!supportsSelectForUpdate(forUpdateType, true)) {
                    throw new JdbcException(MessageCode.DOMA2024, getName());
                }
            }
            transformed = toForUpdateSqlNode(transformed, forUpdateType, options
                    .getWaitSeconds(), aliases);
        }
        return transformed;
    }

    protected SqlNode toPagingSqlNode(SqlNode sqlNode, int offset, int limit) {
        StandardPagingTransformer transformer = new StandardPagingTransformer(
                offset, limit);
        return transformer.transform(sqlNode);
    }

    protected SqlNode toForUpdateSqlNode(SqlNode sqlNode,
            SelectForUpdateType forUpdateType, int waitSeconds,
            String... aliases) {
        StandardForUpdateTransformer transformer = new StandardForUpdateTransformer(
                forUpdateType, waitSeconds, aliases);
        return transformer.transform(sqlNode);
    }

    public boolean isUniqueConstraintViolated(SQLException sqlException) {
        if (sqlException == null) {
            throw new DomaIllegalArgumentException("sqlException", sqlException);
        }
        String state = getSQLState(sqlException);
        if (state != null && state.length() >= 2) {
            String code = state.substring(0, 2);
            return UNIQUE_CONSTRAINT_VIOLATION_STATE_CODES.contains(code);
        }
        return false;
    }

    protected String getSQLState(SQLException sqlException) {
        SQLException cause = getCauseSQLException(sqlException);
        return cause.getSQLState();
    }

    protected int getErrorCode(SQLException sqlException) {
        SQLException cause = getCauseSQLException(sqlException);
        return cause.getErrorCode();
    }

    protected SQLException getCauseSQLException(SQLException sqlException) {
        SQLException cause = sqlException;
        for (Iterator<Throwable> it = sqlException.iterator(); it.hasNext();) {
            Throwable t = it.next();
            if (SQLException.class.isInstance(t)) {
                cause = SQLException.class.cast(t);
            }
        }
        return cause;
    }

    @Override
    public boolean supportsAutoGeneratedKeys() {
        return false;
    }

    @Override
    public boolean supportsBatchUpdateResults() {
        return true;
    }

    @Override
    public boolean supportsIdentity() {
        return false;
    }

    @Override
    public boolean supportsSequence() {
        return false;
    }

    @Override
    public boolean includesIdentityColumn() {
        return false;
    }

    @Override
    public boolean supportsSelectForUpdate(SelectForUpdateType type,
            boolean withTargets) {
        return false;
    }

    @Override
    public boolean supportsResultSetReturningAsOutParameter() {
        return false;
    }

    @Override
    public JdbcType<ResultSet> getResultSetType() {
        throw new DomaUnsupportedOperationException(getClass().getName(),
                "getResultSetType");
    }

    @Override
    public PreparedSql getIdentitySelectSql(String qualifiedTableName,
            String columnName) {
        throw new DomaUnsupportedOperationException(getClass().getName(),
                "getIdentitySelectSql");
    }

    @Override
    public PreparedSql getSequenceNextValSql(String qualifiedSequenceName,
            long allocationSize) {
        throw new DomaUnsupportedOperationException(getClass().getName(),
                "getSequenceNextValString");
    }

    @Override
    public String applyQuote(String name) {
        return OPEN_QUOTE + name + CLOSE_QUOTE;
    }

    @Override
    public String removeQuote(String name) {
        if (name == null || name.length() <= 2) {
            return name;
        }
        char[] chars = name.toCharArray();
        if (chars[0] == OPEN_QUOTE && chars[chars.length - 1] == CLOSE_QUOTE) {
            return new String(chars, 1, chars.length - 2);
        }
        return name;
    }
}
