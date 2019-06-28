package data;

public class Dayinformation{
	

	private String actualtimenoclear;
	private String reasons;
	private String reasons_details;
	private String reasons_explanation;
	private String time;
	private String labelday;
	private String handleovertimework;
	
	


	public String gethandleovertimework() {
		return handleovertimework;
	}


	public void sethandleovertimework(String handleovertimework) {
		this.handleovertimework = handleovertimework;
	}


	public String getLabelday() {
		return labelday;
	}


	public void setLabelday(String labelday) {
		this.labelday = labelday;
	}


	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}
	
	
	public Dayinformation() {

		actualtimenoclear = null;	
		reasons= null;
		reasons_explanation = null;
		reasons_details = null;
		time = null;
		handleovertimework =null;
		labelday = null;
		
	}
	
	
	public void clear() {

		actualtimenoclear = null;
		reasons= null;
		reasons_explanation = null;
		reasons_details = null;
		time = null;
		handleovertimework = null;
		labelday = null;
		
	}
	

	public String getActualtimenoclear() {
		return actualtimenoclear;
	}
	public void setActualtimenoclear(String actualtimenoclear) {
		this.actualtimenoclear = actualtimenoclear;
	}

	public String getreasons() {
		return reasons;
	}
	public void setreasons(String reasons) {
		this.reasons = reasons;
	}
	public String getreasons_explanation() {
		return reasons_explanation;
	}
	public void setreasons_explanation(String reasons_explanation) {
		this.reasons_explanation = reasons_explanation;
	}

	public String getreasons_details() {
		return reasons_details;
	}

	public void setreasons_details(String reasons_details) {
		this.reasons_details = reasons_details;
	}
	
	
		
}