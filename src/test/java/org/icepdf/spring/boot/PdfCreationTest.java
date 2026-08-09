package org.icepdf.spring.boot;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.File;
import java.nio.file.Path;

import org.icepdf.core.pobjects.Document;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Verify test PDF creation works and icepdf can read it.
 */
class PdfCreationTest {

    @TempDir
    Path tempDir;

    @Test
    void createMinimalPdf_createsValidFile() throws Exception {
        File pdf = PdfTestHelper.createMinimalPdf(tempDir.toFile());
        assertThat(pdf).exists();
        assertThat(pdf.length()).isGreaterThan(0);

        // Verify icepdf can read it
        Document doc = new Document();
        try {
            doc.setFile(pdf.getAbsolutePath());
            int pages = doc.getNumberOfPages();
            assertThat(pages).isEqualTo(1);
        } finally {
            doc.dispose();
        }
    }

    @Test
    void createMultiPagePdf_createsValidFile() throws Exception {
        File pdf = PdfTestHelper.createMultiPagePdf(tempDir.toFile(), 3);
        assertThat(pdf).exists();

        Document doc = new Document();
        try {
            doc.setFile(pdf.getAbsolutePath());
            int pages = doc.getNumberOfPages();
            assertThat(pages).isEqualTo(3);
        } finally {
            doc.dispose();
        }
    }
}
