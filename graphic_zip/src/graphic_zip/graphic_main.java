package graphic_zip;

import java.io.BufferedReader;
import java.io.File;

import java.io.IOException;
import java.io.InputStreamReader;

import net.coobird.thumbnailator.Thumbnails;


public class graphic_main {
	
	public static void main(String[] args) {
		
		System.out.println("��ӭʹ�ù¶�ͼƬѹ������" + "\n");
		
		System.out.println("��������Ҫ�趨�ĳ�ʼѹ�����ʣ�0.1-1��,�س�����" + "\n");
		
		System.out.println("ѹ������ԽС�볢�����ø��ͳ�ʼ��ѹ������" + "\n");
		
		String compressRate = ReadInPutword();
		
		float Crate = Float.parseFloat(compressRate);
		
		System.out.println("��������Ҫ�趨��ѹ�����ƣ�С�ڶ���KB����,�س�����" + "\n");
		
		System.out.println("��ע�Ȿ����ṩ�ȱ���ѹ������ζ��ͼƬ����ѹ����С��С����" + "\n");
		
		System.out.println("500KBһ�±���������ȶ�ѹ��������ѹ����200KBһ�£�����ϵ����Ա" + "\n");
		
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
	    			    		
	    		System.out.println("����ѹ��:::->"+InpufileName +"  "+"�벻Ҫ�رմ���!");
	    		
	    		String result= ZipOperation.compressPic("C:\\zip\\", "C:\\zip\\", InpufileName, OutputFileName);
	    			
	    	}
	    	
	    }
	    
	    System.out.println("�����ļ�ѹ�����,���Թرմ�����");
	   
	}
	
	
	public static String ReadInPutword() {
		// TODO �Զ����ɵķ������
    	
	    BufferedReader bufferedReader = null;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    	        
			try {
				return bufferedReader.readLine();
				
			} catch (IOException e) {
				e.printStackTrace();
				return "��ȡ����";
			}
			     	
	}	

}
