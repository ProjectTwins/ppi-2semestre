package entities;

public class Logon {

	private String login;
	private Integer password;
	
	
	public Logon(String login, Integer password) {
		this.login = login;
		this.password = password;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public Integer getPassword() {
		return password;
	}


	public void setPassword(Integer password) {
		this.password = password;
	}
	
	
	
	
}
