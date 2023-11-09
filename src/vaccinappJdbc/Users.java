package vaccinappJdbc;

public class Users {
	
	private int id;
	private String name;
	private String cpf;
	private char gender;
	private String email;
	private String password;
	private String cardSUS;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public char getGender() {
		return gender;
	}
	public void setGender(char gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCardSUS() {
		return cardSUS;
	}
	public void setCardSUS(String cardSUS) {
		this.cardSUS = cardSUS;
	}
	
	
}
