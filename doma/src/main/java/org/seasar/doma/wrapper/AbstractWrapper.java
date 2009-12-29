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
package org.seasar.doma.wrapper;

/**
 * {@link Wrapper} の骨格実装です。
 * 
 * @author taedium
 * 
 */
public abstract class AbstractWrapper<V> implements Wrapper<V> {

    /** 値 */
    protected V value;

    /**
     * インスタンスを構築します。
     */
    public AbstractWrapper() {
    }

    /**
     * 値を指定してインスタンスを構築します。
     * 
     * @param value
     *            値
     */
    public AbstractWrapper(V value) {
        doSet(value);
    }

    @Override
    public final void set(V value) {
        doSet(value);
    }

    protected void doSet(V value) {
        this.value = value;
    }

    @Override
    public final V get() {
        return doGet();
    }

    protected V doGet() {
        return value;
    }

    @Override
    public final V getCopy() {
        return doGetCopy();
    }

    protected V doGetCopy() {
        return doGet();
    }

    @Override
    public final boolean hasEqualValue(Object otherValue) {
        return doHasEqualValue(otherValue);
    }

    protected boolean doHasEqualValue(Object otherValue) {
        V value = doGet();
        if (value == null) {
            return otherValue == null;
        }
        return value.equals(otherValue);
    }

}
