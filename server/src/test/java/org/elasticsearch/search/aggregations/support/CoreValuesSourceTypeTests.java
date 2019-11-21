/*
 * Licensed to Elasticsearch under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.elasticsearch.search.aggregations.support;

import org.elasticsearch.common.io.stream.AbstractWriteableEnumTestCase;

import java.io.IOException;

import static org.hamcrest.Matchers.equalTo;

public class CoreValuesSourceTypeTests extends AbstractWriteableEnumTestCase {

    public CoreValuesSourceTypeTests() {
        super(CoreValuesSourceType::fromStream);
    }

    @Override
    public void testValidOrdinals() {
        assertThat(CoreValuesSourceType.ANY.ordinal(), equalTo(0));
        assertThat(CoreValuesSourceType.NUMERIC.ordinal(), equalTo(1));
        assertThat(CoreValuesSourceType.BYTES.ordinal(), equalTo(2));
        assertThat(CoreValuesSourceType.GEOPOINT.ordinal(), equalTo(3));
        assertThat(CoreValuesSourceType.RANGE.ordinal(), equalTo(4));
        assertThat(CoreValuesSourceType.GEOSHAPE.ordinal(), equalTo(5));
        assertThat(CoreValuesSourceType.GEO.ordinal(), equalTo(6));
    }

    @Override
    public void testFromString() {
        assertThat(CoreValuesSourceType.fromString("any"), equalTo(CoreValuesSourceType.ANY));
        assertThat(CoreValuesSourceType.fromString("numeric"), equalTo(CoreValuesSourceType.NUMERIC));
        assertThat(CoreValuesSourceType.fromString("bytes"), equalTo(CoreValuesSourceType.BYTES));
        assertThat(CoreValuesSourceType.fromString("geopoint"), equalTo(CoreValuesSourceType.GEOPOINT));
        assertThat(CoreValuesSourceType.fromString("range"), equalTo(CoreValuesSourceType.RANGE));
        assertThat(CoreValuesSourceType.fromString("geoshape"), equalTo(CoreValuesSourceType.GEOSHAPE));
        assertThat(CoreValuesSourceType.fromString("geo"), equalTo(CoreValuesSourceType.GEO));
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class,
            () -> CoreValuesSourceType.fromString("does_not_exist"));
        assertThat(e.getMessage(),
            equalTo("No enum constant org.elasticsearch.search.aggregations.support.CoreValuesSourceType.DOES_NOT_EXIST"));
        expectThrows(NullPointerException.class, () -> CoreValuesSourceType.fromString(null));
    }

    @Override
    public void testReadFrom() throws IOException {
        assertReadFromStream(0, CoreValuesSourceType.ANY);
        assertReadFromStream(1, CoreValuesSourceType.NUMERIC);
        assertReadFromStream(2, CoreValuesSourceType.BYTES);
        assertReadFromStream(3, CoreValuesSourceType.GEOPOINT);
        assertReadFromStream(4, CoreValuesSourceType.RANGE);
        assertReadFromStream(5, CoreValuesSourceType.GEOSHAPE);
        assertReadFromStream(6, CoreValuesSourceType.GEO);
    }

    @Override
    public void testWriteTo() throws IOException {
        assertWriteToStream(CoreValuesSourceType.ANY, 0);
        assertWriteToStream(CoreValuesSourceType.NUMERIC, 1);
        assertWriteToStream(CoreValuesSourceType.BYTES, 2);
        assertWriteToStream(CoreValuesSourceType.GEOPOINT, 3);
        assertWriteToStream(CoreValuesSourceType.RANGE, 4);
        assertWriteToStream(CoreValuesSourceType.GEOSHAPE, 5);
        assertWriteToStream(CoreValuesSourceType.GEO, 6);
    }
}