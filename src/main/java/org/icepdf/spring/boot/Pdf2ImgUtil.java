/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
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

/**
 * TODO
 * @author 		： <a href="https://github.com/hiwepy">wandl</a>
 */

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import javax.imageio.ImageIO;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;

public class Pdf2ImgUtil {
	public static void main(String[] args){
		String filePath="G:/BaiduYunDownload/ce.pdf";
		Document document=new Document();
		try{
			document.setFile(filePath);
			float scale=1.0f; //缩放比例
			float rotation=0f; //旋转角度  
			for(int i=0;i<document.getNumberOfPages();i++){
				BufferedImage image=(BufferedImage)document.getPageImage(i,
						GraphicsRenderingHints.SCREEN,Page.BOUNDARY_CROPBOX,
						rotation,scale);
				RenderedImage rendImage=image;
				File file=new File("G:/BaiduYunDownload/icepdf_"+i+".jpg");
				// 这里png作用是：格式是jpg但有png清晰度  
				ImageIO.write(rendImage,"png",file);
				image.flush();  
           }
			document.dispose();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		System.out.println("======================完成============================");
	}
}
