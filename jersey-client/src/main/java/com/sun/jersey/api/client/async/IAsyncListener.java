/*
 *
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2007 Sun Microsystems, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License. You can obtain
 * a copy of the License at https://jersey.dev.java.net/CDDL+GPL.html
 * or jersey/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at jersey/legal/LICENSE.txt.
 * Sun designates this particular file as subject to the "Classpath" exception
 * as provided by Sun in the GPL Version 2 section of the License file that
 * accompanied this code.  If applicable, add the following below the License
 * Header, with the fields enclosed by brackets [] replaced by your own
 * identifying information: "Portions Copyrighted [year]
 * [name of copyright owner]"
 *
 * Contributor(s):
 *
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package com.sun.jersey.api.client.async;

import com.sun.jersey.api.client.*;

/**
 * A listener to be implemented by clients that wish to receive callback
 * notification of the completion of requests invoked asynchronously.
 * <p>
 * Developers may wish to extend from the class {@link AsyncListener} rather
 * than implement this interface directly.
 *
 * @see AsyncListener.
 * @param <T> the type of the response.
 */
public interface IAsyncListener<T> {

    /**
     * Get the class of the instance to receive for
     * {@link #onResponse(java.lang.Object)  }.
     * 
     * @return the class of the response.
     */
    Class<T> getType();

    /**
     * Get the generic type declaring the Java type of the instance to
     * receive for {@link #onResponse(java.lang.Object)  }.
     * 
     * @return the generic type of the response. If null then the method
     *         {@link #getType() } must not return null. Otherwise, if not null,
     *         the type information declared by the generic type takes
     *         precedence over the value returned by {@link #getType() }.
     */
    GenericType<T> getGenericType();

    /**
     * Called when an error occurs.
     *
     * @param t the exeception indicating the error. May be an instance of
     *        {@link UniformInterfaceException} if the status of the HTTP 
     *        response is greater than or equal to 300 and <code>T</code> is 
     *        not the type {@link ClientResponse}.
     */
    void onError(Throwable t);

    /**
     * Called when a response is received.
     * 
     * @param t the response.
     */
    void onResponse(T t);
}