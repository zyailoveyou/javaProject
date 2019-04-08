package graphic_zip;

import java.io.BufferedReader;
import java.io.File;

import java.io.IOException;
import java.io.InputStreamReader;

import net.coobird.thumbnailator.Thumbnails;


public class graphic_main {
	
	public static void main(String[] args) {
		
		System.out.println("欢迎使用孤儿图片压缩工具" + "\n");
		
		System.out.println("请输入你要设定的初始压缩比率（0.1-1）,回车结束" + "\n");
		
		System.out.println("压缩限制越小请尝试设置更低初始的压缩比率" + "\n");
		
		String compressRate = ReadInPutword();
		
		float Crate = Float.parseFloat(compressRate);
		
		System.out.println("请输入你要设定的压缩限制（小于多少KB？）,回车结束" + "\n");
		
		System.out.println("请注意本软件提供等比例压缩，意味着图片具有压缩最小大小限制" + "\n");
		
		System.out.println("500KB一下本软件可以稳定压缩，如想压缩到200KB一下，请联系管理员" + "\n");
		
		String limitKB = ReadInPutword();
		
		int Lkb = Integer.parseInt(limitKB);
		
		filecompress ZipOperation = new filecompress(Crate,Lkb);
		
		File directoryZipFile = new File("C:\\zip");
		
	    File[] files =  directoryZipFile.listFiles();
	    
	    int OutPutNamePostFix = 1;
	    
	    String OutputFileName = null;
	    
	    for(File f:files) {
	    	
	    	if(!f.isDirectory()) {
	    		
	    		String InpufileName = f.getName();
	    		
	    		String FileType = InpufileName.substring(InpufileName.lastIndexOf("."));
	    		
	    		OutputFileName = InpufileName.substring(0, InpufileName.lastIndexOf(".")) + OutPutNamePostFix +".jpg";
	    			    		
	    		System.out.println("正在压缩:::->"+InpufileName +"  "+"请不要关闭窗口!");
	    		
	    		String result= ZipOperation.compressPic("C:\\zip\\", "C:\\zip\\", InpufileName, OutputFileName);
	    			
	    	}
	    	
	    }
	    
	    System.out.println("所有文件压缩完毕,可以关闭窗口了");
	   
	}
	
	
	public static String ReadInPutword() {
		// TODO 自动生成的方法存根
    	
	    BufferedReader bufferedReader = null;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	        
			try {
				return bufferedReader.readLine();
				
			} catch (IOException e) {
				e.printStackTrace();
				return "读取错误";
			}
			     	
	}	

}
