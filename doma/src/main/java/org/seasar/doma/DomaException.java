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
package org.seasar.doma;

import org.seasar.doma.message.MessageCode;
import org.seasar.doma.message.Messages;

/**
 * @author taedium
 * 
 */
public class DomaException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    protected final Enum<?> messageCode;

    protected final Object args;

    public DomaException(MessageCode messageCode, Object... args) {
        this(messageCode, null, args);
    }

    public DomaException(MessageCode messageCode, Throwable cause,
            Object... args) {
        super(Messages.getMessage(messageCode, args), cause);
        this.messageCode = messageCode;
        this.args = args;
    }

    public Enum<?> getMessageCode() {
        return messageCode;
    }

    public Object getArgs() {
        return args;
    }

}
