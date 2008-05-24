/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 * 
 * Copyright 2007 Sun Microsystems, Inc. All rights reserved. 
 * 
 * The contents of this file are subject to the terms of the Common Development
 * and Distribution License("CDDL") (the "License").  You may not use this file
 * except in compliance with the License. 
 * 
 * You can obtain a copy of the License at:
 *     https://jersey.dev.java.net/license.txt
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * When distributing the Covered Code, include this CDDL Header Notice in each
 * file and include the License file at:
 *     https://jersey.dev.java.net/license.txt
 * If applicable, add the following below this CDDL Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 *     "Portions Copyrighted [year] [name of copyright owner]"
 */

package com.sun.jersey.samples.servlet.resources;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.ProduceMime;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;

@Path("/resource1")
public class ResourceBean1 {
    
    @Context
    HttpServletRequest servletRequest;
    
    @Context
    ServletConfig servletConfig;
        
    @GET
    @ProduceMime("text/plain")
    public String describe() {
        return "Hello World from resource 1 in servlet: '" +
                servletConfig.getServletName() +
                "', path: '" +
                servletRequest.getServletPath() +
                "'";
    }
    
}
