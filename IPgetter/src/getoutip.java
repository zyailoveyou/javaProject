import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class getoutip {
	
	
	public String getPublicIp() {
		try {
			String path = "http://iframe.ip138.com/ic.asp";// Ҫ���htmlҳ�����ݵĵ�ַ
 
			URL url = new URL(path);// ����url����
 
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();// ������
 
			conn.setRequestProperty("contentType", "GBK"); // ����url���Ĳ�������
 
			conn.setConnectTimeout(5 * 1000);// �����ʱ��
 
			conn.setRequestMethod("GET");// ����ʽ
 
			InputStream inStream = conn.getInputStream();
			// readLesoSysXML(inStream);
 
			BufferedReader in = new BufferedReader(new InputStreamReader(
					inStream, "GBK"));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			// ��ȡ��ȡ�����ݵ����һ��,д��
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
			String str = buffer.toString();
			String ipString1 = str.substring(str.indexOf("[")); 
			// ��ȡ���IP���м��[182.149.82.50]����
			String ipsString2 = ipString1.substring(ipString1.indexOf("[") + 1,
					ipString1.lastIndexOf("]"));
			//��ȡ��ǰIP��ַ���ڵ�ַ
		/*	String ipsString3=ipString1.substring(ipString1.indexOf(": "),ipString1.lastIndexOf("</center>"));
			System.err.println(ipsString3);*/
			
			// ���ع���IPֵ
			return ipsString2;
 
		} catch (Exception e) {
			System.out.println("��ȡ����IP���ӳ�ʱ");
			return "���ӳ�ʱ";
		}
	}



}
