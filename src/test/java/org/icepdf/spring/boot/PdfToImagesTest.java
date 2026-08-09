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
package org.icepdf.spring.boot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link PdfToImages}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 */
class PdfToImagesTest {

    @Test
    void jpgFilename_withValidPath_returnsFormattedFilename() {
        String result = PdfToImages.jpgFilename("C:\\docs\\test.pdf", 0);
        assertThat(result).contains("test-1.jpg");
    }

    @Test
    void jpgFilename_withIndex1_returnsIncrementedFilename() {
        String result = PdfToImages.jpgFilename("C:\\docs\\myfile.pdf", 1);
        assertThat(result).contains("myfile-2.jpg");
    }

    @Test
    void jpgFilename_withNull_returnsEmpty() {
        String result = PdfToImages.jpgFilename(null, 0);
        assertThat(result).isEmpty();
    }

    @Test
    void jpgFilename_withEmptyString_returnsEmpty() {
        String result = PdfToImages.jpgFilename("", 0);
        assertThat(result).isEmpty();
    }

    @Test
    void constants_haveExpectedValues() {
        assertThat(PdfToImages.FILETYPE_JPG).isEqualTo("jpg");
        assertThat(PdfToImages.SUFF_IMAGE).isEqualTo(".jpg");
    }
}
