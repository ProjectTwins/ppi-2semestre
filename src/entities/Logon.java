package entities;

public class Logon {

	private String login ;
	private String senha ;
	
	
	public Logon(String login, String senha) {
	
		this.login = login;
		this.senha = senha;
	}
	
	public Logon() {
		
	}

	public String getLogin() {
		return login;
	}


	public String getSenha() {
		return senha;
	}
	
	public boolean Autenticação() {
		if((this.login.equals("adm")) && (this.senha.equals("adm"))) {
			return true;
		}
		else
			return false;
	}
	
	public void print() {
		System.out.println(this.login + " " + this.senha);
	}
	
}
