package dev.beale.models;

public class Message {

	private int id;
	private int Rid;
	private int receiver;
	private String sender;
	private String msgInfo;
	private long msgDate;

	public Message() {
		super();
	}

	public Message(int id, int rid, int receiver, String sender, String msgInfo, long msgDate) {
		super();
		this.id = id;
		Rid = rid;
		this.receiver = receiver;
		this.sender = sender;
		this.msgInfo = msgInfo;
		this.msgDate = msgDate;
	}

	public Message(int rid, int receiver, String sender, String msgInfo, long msgDate) {
		super();
		Rid = rid;
		this.receiver = receiver;
		this.sender = sender;
		this.msgInfo = msgInfo;
		this.msgDate = msgDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getRid() {
		return Rid;
	}

	public void setRid(int rid) {
		Rid = rid;
	}

	public int getReceiver() {
		return receiver;
	}

	public void setReceiver(int receiver) {
		this.receiver = receiver;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getMsgInfo() {
		return msgInfo;
	}

	public void setMsgInfo(String msgInfo) {
		this.msgInfo = msgInfo;
	}

	public long getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(long msgDate) {
		this.msgDate = msgDate;
	}

	@Override
	public String toString() {
		return "Message [id=" + id + ", Rid=" + Rid + ", receiver=" + receiver + ", sender=" + sender + ", msgInfo="
				+ msgInfo + ", msgDate=" + msgDate + "]";
	}

}
