package mutiple_type;

class caculate {
	
}

class mutiple_descent extends caculate{}



class mutiple_plus <T extends caculate>{
	
	public T good1;
	
	public void out() {
		
		System.out.println(good1);
		
	}
	
}


public class muti_type_main {
	
	
	public static void main(String[] args) {
		
		
		mutiple_plus good1 = new mutiple_plus();
		
		System.out.println(good1);
	}

}
