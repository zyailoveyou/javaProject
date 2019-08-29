package vacation_extrawork;

public class Approvel_N_Dayinformation extends Dayinformation {
	
	private int VACATION_NORMAL_PASSED;
	private String LEVEL_SHAPE;
	private String DEPARTMENT;
	private String VACATION_APPROVAL_NORMAL_UPPER;
	
	
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
