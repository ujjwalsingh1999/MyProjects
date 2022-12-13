package com.project.contactManager;

public class contactDetails {//blueprint for application
	private String contactName;
	private int contact_id;
	private String contactdescription;
	private int phone;
	private String contactEmail;
	public void setphone(int phone) {
		this.phone=phone;

	}
	public int getphone() {
		return phone;
	}
	public void setcontactName (String contactName) {
		this.contactName=contactName;
	}
	public String getcontactName() {
		return contactName;
	}
	public void setcontact_id(int contact_id) {
		this.contact_id= contact_id;
	}
	public int  getcontact_id() {
		return contact_id;
	}
	public void  setcontactdescription(String contactdescription) {
		this.contactdescription=contactdescription;
	}
	public String getcontactdescription() {
		return contactdescription;
	}
	public void setcontactEmail (String contactEmail) {
		this.contactEmail=contactEmail;
	}
	public String getcontactEmail() {
		return contactEmail;
	}
}



