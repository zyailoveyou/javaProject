package vacation_extrawork;

public class Approvel_N_Dayinformation extends Dayinformation implements Cloneable {
	
	
	private int WHETHERNEEDHIGHPASS = 0;
	private int VACATION_SPECIAL_PASSED;
	private int VACATION_NORMAL_PASSED;
	private String LEVEL_SHAPE;
	private String DEPARTMENT;
	private String VACATION_APPROVAL_NORMAL_UPPER;
	private String VACATION_APPROVAL_HIGHER_UPPER;
	
	
	@Override
	protected Approvel_N_Dayinformation clone() throws CloneNotSupportedException {
		// TODO 自动生成的方法存根
		return (Approvel_N_Dayinformation)super.clone();
	}
	
	public String getVACATION_APPROVAL_HIGHER_UPPER() {
		return VACATION_APPROVAL_HIGHER_UPPER;
	}

	public void setVACATION_APPROVAL_HIGHER_UPPER(String vACATION_APPROVAL_HIGHER_UPPER) {
		VACATION_APPROVAL_HIGHER_UPPER = vACATION_APPROVAL_HIGHER_UPPER;
	}

	public int getWHETHERNEEDHIGHPASS() {
		return WHETHERNEEDHIGHPASS;
	}

	public void setWHETHERNEEDHIGHPASS(int wHETHERNEEDHIGHPASS) {
		WHETHERNEEDHIGHPASS = wHETHERNEEDHIGHPASS;
	}

	public int getVACATION_SPECIAL_PASSED() {
		return VACATION_SPECIAL_PASSED;
	}

	public void setVACATION_SPECIAL_PASSED(int vACATION_SPECIAL_PASSED) {
		VACATION_SPECIAL_PASSED = vACATION_SPECIAL_PASSED;
	}
	
	
	public String getVACATION_APPROVAL_NORMAL_UPPER() {
		return VACATION_APPROVAL_NORMAL_UPPER;
	}
	
	public void setVACATION_APPROVAL_NORMAL_UPPER(String vACATION_APPROVAL_NORMAL_UPPER) {
		VACATION_APPROVAL_NORMAL_UPPER = vACATION_APPROVAL_NORMAL_UPPER;
	}
	
	public int getVACATION_NORMAL_PASSED() {
		return VACATION_NORMAL_PASSED;
	}
	
	public void setVACATION_NORMAL_PASSED(int vACATION_NORMAL_PASSED) {
		VACATION_NORMAL_PASSED = vACATION_NORMAL_PASSED;
	}
	
	public String getLEVEL_SHAPE() {
		return LEVEL_SHAPE;
	}
	
	public void setLEVEL_SHAPE(String lEVEL_SHAPE) {
		LEVEL_SHAPE = lEVEL_SHAPE;
	}
	
	public String getDEPARTMENT() {
		return DEPARTMENT;
	}
	
	public void setDEPARTMENT(String dEPARTMENT) {
		DEPARTMENT = dEPARTMENT;
	}
	
}
