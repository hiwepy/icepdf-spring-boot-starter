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
package org.icepdf.core.pobjects.graphics;

import static org.assertj.core.api.Assertions.assertThatCode;

import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link Padding}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
class PaddingTest {

    @Test
    void getPadding_withValidGraphics_doesNotThrow() {
        BufferedImage image = new BufferedImage(200, 200, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        Rectangle2D.Float mediaBox = new Rectangle2D.Float(0, 0, 200, 200);

        assertThatCode(() -> {
            Padding.getPadding(g2, mediaBox);
        }).doesNotThrowAnyException();

        g2.dispose();
    }

    @Test
    void getPadding_withDifferentSizes_doesNotThrow() {
        BufferedImage image = new BufferedImage(400, 600, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = image.createGraphics();
        Rectangle2D.Float mediaBox = new Rectangle2D.Float(10, 20, 380, 560);

        assertThatCode(() -> {
            Padding.getPadding(g2, mediaBox);
        }).doesNotThrowAnyException();

        g2.dispose();
    }
}
