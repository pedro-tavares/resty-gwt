/**
 * Copyright (C) 2010, Progress Software Corporation and/or its 
 * subsidiaries or affiliates.  All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fusesource.restygwt.examples.server;

import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXBContext;

import org.fusesource.restygwt.examples.client.MapResult;

import com.sun.jersey.api.json.JSONConfiguration;
import com.sun.jersey.api.json.JSONJAXBContext;

@Provider
public class JsonJaxbProvider {
    
    private JAXBContext context;
    private Class<?>[] types = { MapResult.class };

    public JsonJaxbProvider() throws Exception {
        JSONConfiguration config = JSONConfiguration.natural().build();
        context = new JSONJAXBContext(config, types);
    } 

    public JAXBContext getContext(Class<?> objectType) {
        for (Class<?> type : types) {
            if (type == objectType) {
                return context;
            }
        }
        return null;
    }

}
