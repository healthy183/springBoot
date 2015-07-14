package spring.boot.first.mvc.jsonObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements java.io.Serializable {

	 private String name;
	 
	 private String password;
	 
	 private Integer age;
	 
	 private Address address;
	 
	 private String[] favourite;
	 
	 
	
}
