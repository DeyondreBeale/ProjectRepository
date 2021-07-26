package dev.beale.models;

import org.apache.log4j.Logger;

public class Reimbursement {

	static final Logger log = Logger.getLogger(Reimbursement.class);

	private int id;
	private int Eid;
	private int amount;
	private boolean supervisorApproved;
	private boolean departHeadApproved;
	private boolean benCoApproved;
	private String dateSubmitted;
	private String timeRequirement;
	private boolean autoApprove;
	private String location;
	private String description;
	private String status;
	private String gradeFormat;
	private String justification;
	private byte fileAttachment;
	private String eventType;

	public Reimbursement() {
		super();
	}

	public Reimbursement(int id, int eid, int amount, boolean supervisorApproved, boolean departHeadApproved,
			boolean benCoApproved, String dateSubmitted, String timeRequirement, boolean autoApprove, String location,
			String description, String status, String gradeFormat, String justification, byte fileAttachment,
			String eventType) {
		super();
		this.id = id;
		Eid = eid;
		this.amount = amount;
		this.supervisorApproved = supervisorApproved;
		this.departHeadApproved = departHeadApproved;
		this.benCoApproved = benCoApproved;
		this.dateSubmitted = dateSubmitted;
		this.timeRequirement = timeRequirement;
		this.autoApprove = autoApprove;
		this.location = location;
		this.description = description;
		this.status = status;
		this.gradeFormat = gradeFormat;
		this.justification = justification;
		this.fileAttachment = fileAttachment;
		this.eventType = eventType;
	}

	public Reimbursement(int eid, int amount, boolean supervisorApproved, boolean departHeadApproved,
			boolean benCoApproved, String dateSubmitted, String timeRequirement, boolean autoApprove, String location,
			String description, String status, String gradeFormat, String justification, byte fileAttachment,
			String eventType) {
		super();
		Eid = eid;
		this.amount = amount;
		this.supervisorApproved = supervisorApproved;
		this.departHeadApproved = departHeadApproved;
		this.benCoApproved = benCoApproved;
		this.dateSubmitted = dateSubmitted;
		this.timeRequirement = timeRequirement;
		this.autoApprove = autoApprove;
		this.location = location;
		this.description = description;
		this.status = status;
		this.gradeFormat = gradeFormat;
		this.justification = justification;
		this.fileAttachment = fileAttachment;
		this.eventType = eventType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getEid() {
		return Eid;
	}

	public void setEid(int eid) {
		Eid = eid;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public boolean isSupervisorApproved() {
		return supervisorApproved;
	}

	public void setSupervisorApproved(boolean supervisorApproved) {
		this.supervisorApproved = supervisorApproved;
	}

	public boolean isDepartHeadApproved() {
		return departHeadApproved;
	}

	public void setDepartHeadApproved(boolean departHeadApproved) {
		this.departHeadApproved = departHeadApproved;
	}

	public boolean isBenCoApproved() {
		return benCoApproved;
	}

	public void setBenCoApproved(boolean benCoApproved) {
		this.benCoApproved = benCoApproved;
	}

	public String getDateSubmitted() {
		return dateSubmitted;
	}

	public void setDateSubmitted(String dateSubmitted) {
		this.dateSubmitted = dateSubmitted;
	}

	public String getTimeRequirement() {
		return timeRequirement;
	}

	public void setTimeRequirement(String timeRequirement) {
		this.timeRequirement = timeRequirement;
	}

	public boolean isAutoApprove() {
		return autoApprove;
	}

	public void setAutoApprove(boolean autoApprove) {
		this.autoApprove = autoApprove;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getGradeFormat() {
		return gradeFormat;
	}

	public void setGradeFormat(String gradeFormat) {
		this.gradeFormat = gradeFormat;
	}

	public String getJustification() {
		return justification;
	}

	public void setJustification(String justification) {
		this.justification = justification;
	}

	public byte getFileAttachment() {
		return fileAttachment;
	}

	public void setFileAttachment(byte fileAttachment) {
		this.fileAttachment = fileAttachment;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return "Reimbursement [id=" + id + ", Eid=" + Eid + ", amount=" + amount + ", supervisorApproved="
				+ supervisorApproved + ", departHeadApproved=" + departHeadApproved + ", benCoApproved=" + benCoApproved
				+ ", dateSubmitted=" + dateSubmitted + ", timeRequired=" + timeRequirement + ", autoApprove="
				+ autoApprove + ", location=" + location + ", description=" + description + ", status=" + status
				+ ", gradeFormat=" + gradeFormat + ", justification=" + justification + ", fileAttachment="
				+ fileAttachment + ", eventType=" + eventType + "]";
	}
}
