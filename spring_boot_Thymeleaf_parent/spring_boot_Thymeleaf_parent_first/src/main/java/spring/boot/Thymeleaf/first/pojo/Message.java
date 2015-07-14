package spring.boot.Thymeleaf.first.pojo;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

public class Message implements java.io.Serializable {

	private Integer id;

	private Date created;
	@NotEmpty
	private String summary;
	
	private Boolean isTrue = Boolean.TRUE;
	
	private Integer amount;
	
	private double price;

	public Message() {
		super();
	}

	public Message(Integer id, Date created, String summary) {
		super();
		this.id = id;
		this.created = created;
		this.summary = summary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Boolean getIsTrue() {
		return isTrue;
	}

	public void setIsTrue(Boolean isTrue) {
		this.isTrue = isTrue;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	
	
}
