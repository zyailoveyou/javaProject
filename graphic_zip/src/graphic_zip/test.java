package graphic_zip;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

public class test {
	
	public static void main(String[] args) {
		
		

	    		try {
					Thumbnails.of("C:\\zip\\金猪挂坠.png").scale(1f).outputQuality(0.1f).toFile("C:\\zip\\金猪挂坠1.jpg");
				} catch (IOException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
	    		

	   
		
	}

}
