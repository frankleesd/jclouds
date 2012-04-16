/**
 * Licensed to jclouds, Inc. (jclouds) under one or more
 * contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  jclouds licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.jclouds.openstack.nova.v1_1.functions;


import javax.inject.Singleton;
import javax.ws.rs.core.HttpHeaders;

import org.jclouds.http.HttpResponse;
import org.jclouds.openstack.nova.v1_1.domain.Image;

import com.google.common.base.Function;
 

/**
 * This parses {@link Image} from the body of the link in the Location header of the HTTPResponse.
 * 
 * @author Tim Miller
 */
@Singleton
public class ParseImageIdFromLocationHeader implements Function<HttpResponse, String> {

	public String apply(HttpResponse response) {
        String location = response.getFirstHeaderOrNull(HttpHeaders.LOCATION);
        String[] parts = location.split("/");
        return parts[parts.length - 1];
    }
}
