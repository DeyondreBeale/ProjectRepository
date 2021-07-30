package dev.beale.models;

public class Request {

	private int id;
	private int Eid;
	private int Rid;
	private String department;
	private String reason;
	private String dateSent;
	private boolean urgent;
	private boolean denied;

	public Request() {
		super();
	}

	public Request(int id, int eid, int rid, String department, String reason, String dateSent, boolean urgent,
			boolean denied) {
		super();
		this.id = id;
		Eid = eid;
		Rid = rid;
		this.department = department;
		this.reason = reason;
		this.dateSent = dateSent;
		this.urgent = urgent;
		this.denied = denied;
	}

	public Request(int eid, int rid, String department, String reason, String dateSent, boolean urgent,
			boolean denied) {
		super();
		Eid = eid;
		Rid = rid;
		this.department = department;
		this.reason = reason;
		this.dateSent = dateSent;
		this.urgent = urgent;
		this.denied = denied;
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

	public int getRid() {
		return Rid;
	}

	public void setRid(int rid) {
		Rid = rid;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getDateSent() {
		return dateSent;
	}

	public void setDateSent(String dateSent) {
		this.dateSent = dateSent;
	}

	public boolean isUrgent() {
		return urgent;
	}

	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}

	public boolean isDenied() {
		return denied;
	}

	public void setDenied(boolean denied) {
		this.denied = denied;
	}

	@Override
	public String toString() {
		return "Request [id=" + id + ", Eid=" + Eid + ", Rid=" + Rid + ", department=" + department + ", reason="
				+ reason + ", dateSent=" + dateSent + ", urgent=" + urgent + ", denied=" + denied + "]";
	}

}
