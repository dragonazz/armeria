/*
 * Copyright 2016 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package com.linecorp.armeria.client.routing;

import com.google.common.collect.ImmutableList;

import static java.util.Objects.requireNonNull;

import java.util.List;

public final class StaticEndpointGroup<T extends Endpoint> implements EndpointGroup<T> {

    private final List<T> endpoints;

    public StaticEndpointGroup(T... endpoints) {
        requireNonNull(endpoints, "endpoints");

        this.endpoints = ImmutableList.copyOf(endpoints);
    }

    public StaticEndpointGroup(Iterable<? extends T> endpoints) {
        requireNonNull(endpoints, "endpoints");

        this.endpoints = ImmutableList.copyOf(endpoints);
    }

    @Override
    public List<T> endpoints() {
        return endpoints;
    }

    @Override
    public String toString() {
        StringBuilder buf = new StringBuilder();
        buf.append("StaticEndpointGroup(");
        for (Endpoint endpoint : endpoints) {
            buf.append(endpoint.toString()).append(",");
        }
        buf.setCharAt(buf.length() - 1, ')');

        return buf.toString();
    }

}
