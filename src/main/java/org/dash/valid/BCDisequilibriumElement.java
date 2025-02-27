package org.dash.valid;

public abstract class BCDisequilibriumElement implements DisequilibriumElement {
	private String hlabElement;
	private String hlacElement;
	
	public String getHlabElement() {
		return hlabElement;
	}
	public void setHlabElement(String bElement) {
		this.hlabElement = bElement;
	}
	public String getHlacElement() {
		return hlacElement;
	}
	public void setHlacElement(String cElement) {
		this.hlacElement = cElement;
	}
	
	@Override
	public abstract String getFrequencyInfo();
}
