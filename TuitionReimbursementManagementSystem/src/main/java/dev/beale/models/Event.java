package dev.beale.models;

public class Event {

	private int id;
	private String fileAttachment;
	private String gradingType;
	private String eventType;

	public Event() {
		super();
	}

	public Event(int id, String fileAttachment, String gradingType, String eventType) {
		super();
		this.id = id;
		this.fileAttachment = fileAttachment;
		this.gradingType = gradingType;
		this.eventType = eventType;
	}

	public Event(String fileAttachment, String gradingType, String eventType) {
		super();
		this.fileAttachment = fileAttachment;
		this.gradingType = gradingType;
		this.eventType = eventType;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileAttachment() {
		return fileAttachment;
	}

	public void setFileAttachment(String fileAttachment) {
		this.fileAttachment = fileAttachment;
	}

	public String getGradingType() {
		return gradingType;
	}

	public void setGradingType(String gradingType) {
		this.gradingType = gradingType;
	}

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", fileAttachment=" + fileAttachment + ", gradingType=" + gradingType
				+ ", eventType=" + eventType + "]";
	}

}
