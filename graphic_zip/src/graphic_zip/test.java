package graphic_zip;

import java.io.File;
import java.io.IOException;

import net.coobird.thumbnailator.Thumbnails;

public class test {
	
	public static void main(String[] args) {
		
		

	    		try {
					Thumbnails.of("C:\\zip\\�����׹.png").scale(1f).outputQuality(0.1f).toFile("C:\\zip\\�����׹1.jpg");
				} catch (IOException e) {
					// TODO �Զ����ɵ� catch ��
					e.printStackTrace();
				}
	    		

	   
		
	}

}
