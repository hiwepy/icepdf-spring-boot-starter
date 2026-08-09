/*
 * Copyright (c) 2018, hiwepy (https://github.com/easy-4-java).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.icepdf.core.application;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link ProductInfo}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 */
class ProductInfoTest {

    @Test
    void constructor_createsInstance() {
        ProductInfo info = new ProductInfo();
        assertThat(info).isNotNull();
    }

    @Test
    void toString_containsCompanyAndProduct() {
        ProductInfo info = new ProductInfo();
        String result = info.toString();
        assertThat(result).contains("ICEsoft Technologies, Inc.");
        assertThat(result).contains("ICEpdf");
    }

    @Test
    void toString_containsVersion() {
        ProductInfo info = new ProductInfo();
        String result = info.toString();
        assertThat(result).contains("6.3.2");
    }

    @Test
    void toString_containsBuildNumber() {
        ProductInfo info = new ProductInfo();
        String result = info.toString();
        assertThat(result).contains("Build number:");
        assertThat(result).contains("19");
    }

    @Test
    void toString_containsRevision() {
        ProductInfo info = new ProductInfo();
        String result = info.toString();
        assertThat(result).contains("Revision:");
        assertThat(result).contains("49267");
    }

    @Test
    void getVersion_returnsEmptyString() {
        ProductInfo info = new ProductInfo();
        String version = info.getVersion();
        assertThat(version).isNotNull();
        assertThat(version).isEmpty();
    }

    @Test
    void staticFields_haveExpectedValues() {
        assertThat(ProductInfo.COMPANY).isEqualTo("ICEsoft Technologies, Inc.");
        assertThat(ProductInfo.PRODUCT).isEqualTo("ICEpdf");
        assertThat(ProductInfo.VERSION).isEqualTo("6.3.2");
        assertThat(ProductInfo.RELEASE_TYPE).isEmpty();
        assertThat(ProductInfo.BUILD_NO).isEqualTo("19");
        assertThat(ProductInfo.REVISION).isEqualTo("49267");
    }
}
