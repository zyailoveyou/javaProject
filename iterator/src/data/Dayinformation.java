package data;

public class Dayinformation{
	

	private String actualtimenoclear;
	private String catogorys;
	private String subcatogory;
	private String explainreason;
	private String time;
	private String labelday;
	
	


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

		catogorys= null;
		explainreason = null;
		subcatogory = null;
		time = null;
	}
	
	
	public void clear() {

		actualtimenoclear = null;

		catogorys= null;
		explainreason = null;
		subcatogory = null;
		time = null;
		
	}
	

	public String getActualtimenoclear() {
		return actualtimenoclear;
	}
	public void setActualtimenoclear(String actualtimenoclear) {
		this.actualtimenoclear = actualtimenoclear;
	}

	public String getCatogorys() {
		return catogorys;
	}
	public void setCatogorys(String catogorys) {
		this.catogorys = catogorys;
	}
	public String getExplainreason() {
		return explainreason;
	}
	public void setExplainreason(String explainreason) {
		this.explainreason = explainreason;
	}

	public String getSubcatogory() {
		return subcatogory;
	}

	public void setSubcatogory(String subcatogory) {
		this.subcatogory = subcatogory;
	}
	
	
		
}