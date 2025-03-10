package graphic_zip;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGEncodeParam;
import com.sun.image.codec.jpeg.JPEGImageEncoder;

import net.coobird.thumbnailator.Thumbnails;

/*
 * 
 * 
 * 
 */



public class filecompress {
	
	
	  //初始压缩比率
	  private float IntialCompressRate = 1f;
	  private int LimitSizeKB = 0;
	  private float RemindIntialCompressRate = 0;
	
	//构造函数可以设置压缩比率
	  public filecompress(float IntialCompressRate,int LimitSizeKB) {
		  
		  this.IntialCompressRate = IntialCompressRate;
		  this.LimitSizeKB = LimitSizeKB;
		  this.RemindIntialCompressRate = this.IntialCompressRate;
		  
	  }
	  
	//构造函数默认压缩比率
	  public filecompress() {
		  
		   this.IntialCompressRate = 0.25f;
		   this.LimitSizeKB =500;
		   this.RemindIntialCompressRate = this.IntialCompressRate;
	  }
	
	  
	   
	  //压缩函数
	  public String compressPic(String inputDir, 
			                           String outputDir,
			                           String inputFileName,
			                           String outputFileName) {    
		  
      	String InPutFileInformation = inputDir + inputFileName;
    	
        File InPutFile = new File(InPutFileInformation); 
        
        if(InPutFile.length()<(LimitSizeKB*1024))
        {
        	return "默认文件文件已经小"+LimitSizeKB+"kb，不需要压缩";
        }
		  
	        try {  
	        
	            if(InPutFile.exists()){
	            	
	            	String OutPutFileInformation = outputDir + "result\\" + outputFileName; 
	            	
	            	String OutPutFileDirectoryInformation = outputDir + "result\\";
	            	
	            	File OutPutFileDirectory = new File(OutPutFileDirectoryInformation); 
	            	
	            	if (!OutPutFileDirectory.exists()) {
	            		
	            		OutPutFileDirectory.mkdirs();
						
					}
	 
	            	File OutPutFile = new File(OutPutFileInformation); 
	            	
	            	Thumbnails.of(InPutFileInformation).scale(1f).outputQuality(IntialCompressRate).toFile(OutPutFile);
	         	    
	                if(OutPutFile.length()<(LimitSizeKB*1024))
	                {
	                	IntialCompressRate = RemindIntialCompressRate;
	                	System.out.println("压缩成功，文件小鱼"+LimitSizeKB+"kb，输出");
	                	return "压缩成功，文件小于"+LimitSizeKB+"kb，输出";
	                }
	            	
	                else {
	                	IntialCompressRate = IntialCompressRate - 0.1f;
	                	
	                	if (IntialCompressRate <= 0.1f  ) {
	                		IntialCompressRate = 0.1f;
	                		Thumbnails.of(InPutFileInformation).scale(1f).outputQuality(IntialCompressRate).toFile(OutPutFile);
	                		IntialCompressRate = RemindIntialCompressRate;
	                		System.out.println("已经达成了极限压缩比，不能比压缩比" + 0.1 + "更小");
	                		return "已经达成了极限压缩比，不能比压缩比" + IntialCompressRate + "更小";
	                		
						}
	                	compressPic(inputDir,outputDir,inputFileName,outputFileName);	
					}
	            	 	
	            }
	                      
	            else{
	            	System.out.println(InPutFileInformation + "找不到这个压缩文件");
	            	return InPutFileInformation + "找不到这个压缩文件";
	            }
	            
	         } catch (IOException ex) {  
	        	System.out.println(ex);
	        	System.out.println(InPutFileInformation+"压缩比率"+IntialCompressRate+"文件压缩不成功，请联系管理员");
	            ex.printStackTrace();  
	            return inputFileName;  
	        }  
	        
	        return outputFileName;  
	    }  

	  
	  

}
