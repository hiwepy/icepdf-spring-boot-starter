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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.Test;

/**
 * Tests for {@link HtmlHelper}.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 */
class HtmlHelperTest {

    @Test
    void getHtml_withNull_returnsNull() {
        assertThat(HtmlHelper.getHtml(null)).isNull();
    }

    @Test
    void getHtml_withEmptyList_returnsNull() {
        assertThat(HtmlHelper.getHtml(Collections.emptyList())).isNull();
    }

    @Test
    void getHtml_withSingleImage_returnsValidHtml() {
        List<String> imgs = Arrays.asList("img1.png");
        String html = HtmlHelper.getHtml(imgs);
        assertThat(html).isNotNull();
        assertThat(html).contains("<html>");
        assertThat(html).contains("</html>");
        assertThat(html).contains("img1.png");
        assertThat(html).contains("prev()");
        assertThat(html).contains("next()");
    }

    @Test
    void getHtml_withMultipleImages_returnsValidHtml() {
        List<String> imgs = Arrays.asList("img1.png", "img2.png", "img3.png");
        String html = HtmlHelper.getHtml(imgs);
        assertThat(html).isNotNull();
        assertThat(html).contains("img1.png");
        assertThat(html).contains("img2.png");
        assertThat(html).contains("img3.png");
        assertThat(html).contains("pngAry");
    }

    @Test
    void getHtml_withTwoImages_returnsValidHtml() {
        List<String> imgs = Arrays.asList("first.jpg", "second.jpg");
        String html = HtmlHelper.getHtml(imgs);
        assertThat(html).isNotNull();
        assertThat(html).contains("first.jpg");
        assertThat(html).contains("second.jpg");
    }

    @Test
    void staticConstants_areNotNull() {
        assertThat(HtmlHelper.dviImgP_head).isNotNull();
        assertThat(HtmlHelper.dviBtns).isNotNull();
        assertThat(HtmlHelper.js).isNotNull();
        assertThat(HtmlHelper.whole_head).isNotNull();
        assertThat(HtmlHelper.whole_end).isNotNull();
    }

    @Test
    void wholeHead_containsExpectedStructure() {
        assertThat(HtmlHelper.whole_head).contains("<html>");
        assertThat(HtmlHelper.whole_head).contains("<img");
    }

    @Test
    void wholeEnd_closesHtml() {
        assertThat(HtmlHelper.whole_end).contains("</body>");
        assertThat(HtmlHelper.whole_end).contains("</html>");
    }
}
