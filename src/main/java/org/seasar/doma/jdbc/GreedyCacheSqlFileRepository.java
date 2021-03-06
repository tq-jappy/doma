/*
 * Copyright 2004-2010 the Seasar Foundation and the Others.
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

import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.seasar.doma.jdbc.dialect.Dialect;

/**
 * SQLの解析結果をメモリが許す限り最大限にキャッシュする {@link SqlFileRepository} の実装です。
 * 
 * @author taedium
 * 
 */
public class GreedyCacheSqlFileRepository extends AbstractSqlFileRepository {

    /** SQLのパスをキー、SQLファイルを値とするマップです。 */
    protected final ConcurrentMap<String, SqlFile> sqlFileMap = new ConcurrentHashMap<String, SqlFile>(
            200);

    @Override
    protected SqlFile getSqlFileWithCacheControl(Method method, String path,
            Dialect dialect) {
        SqlFile file = sqlFileMap.get(path);
        if (file != null) {
            return file;
        }
        file = createSqlFile(path, dialect);
        SqlFile current = sqlFileMap.putIfAbsent(path, file);
        return current != null ? current : file;
    }

}
