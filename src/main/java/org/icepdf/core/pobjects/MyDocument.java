package org.icepdf.core.pobjects;

import java.lang.reflect.Field;

/**
 * Extended document class for ICEpdf with additional functionality.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 * @since 1.0.0
 */
public class MyDocument extends Document {

    // 通过反射去掉水印文字资源，使其打印不出
    {
        try {
            Class<?> clazzA = Document.class;

            // Try to clear watermark callback
            Field watermarkField = clazzA.getDeclaredField("watermarkCallback");
            watermarkField.setAccessible(true);
            watermarkField.set(this, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
