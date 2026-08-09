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

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.io.File;
import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Tests for {@link PdfToHtml}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 */
class PdfToHtmlTest {

    @TempDir
    Path tempDir;

    @Test
    void pdf2Pic_withValidPdf_convertsPages() throws Exception {
        File pdf = PdfTestHelper.createMinimalPdf(tempDir.toFile());
        String outputDir = tempDir.toString() + File.separator;

        assertThatCode(() -> PdfToHtml.pdf2Pic(pdf.getAbsolutePath(), outputDir))
                .doesNotThrowAnyException();
    }

    @Test
    void pdf2Pic_withMultiPagePdf_convertsAllPages() throws Exception {
        File pdf = PdfTestHelper.createMultiPagePdf(tempDir.toFile(), 2);
        String outputDir = tempDir.toString() + File.separator;

        assertThatCode(() -> PdfToHtml.pdf2Pic(pdf.getAbsolutePath(), outputDir))
                .doesNotThrowAnyException();
    }

    @Test
    void pdf2Pic_withNonExistentFile_throwsException() {
        assertThatThrownBy(() -> {
            PdfToHtml.pdf2Pic("/nonexistent/file.pdf", "/tmp/");
        }).isInstanceOf(Exception.class);
    }
}
