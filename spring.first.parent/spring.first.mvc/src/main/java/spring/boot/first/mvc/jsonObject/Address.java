package spring.boot.first.mvc.jsonObject;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address  implements java.io.Serializable {

	
	private String province;
	private String city;
	
	
}
