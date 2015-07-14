package spring.boot.Thymeleaf.first.pojo;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {

	private Integer id;

	private String usrName;
	
	private List<Message> messageList;

	public User() {
		super();
	}

	public User(Integer id, String usrName) {
		super();
		this.id = id;
		this.usrName = usrName;
	}

	public Integer getId() {
		return id;
	}

	public String getUsrName() {
		return usrName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsrName(String usrName) {
		this.usrName = usrName;
	}

	public List<Message> getMessageList() {
		return messageList;
	}

	public void setMessageList(List<Message> messageList) {
		this.messageList = messageList;
	}

	
	
	
}
