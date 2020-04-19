package com.csii.webhook.model.pojo;

public class Users {
	public Users(){}

	public Users(Integer id, String name, Integer age, String login, String password){
		this.id = id;
		this.name = name;
		this.age = age;
		this.login = login;
		this.password = password;

	}
	private Integer id;
	private String name;
	private Integer  age;
	private String login;
	private String password;

	public void setLogin(String login) {
		this.login = login;
	}
	public String getLogin() {
		return login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Users{" +
				"id=" + id +
				", name='" + name + '\'' +
				", age=" + age +
				", login"+login +
				", password"+ password+
				'}';
	}
}



