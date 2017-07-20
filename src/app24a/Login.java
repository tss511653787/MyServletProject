package app24a;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Login implements Serializable {
	private static final long serialVersionUID = -38L;
	@Size(min = 1, max = 10)
	private String userName;
	@NotNull
	private String password;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
