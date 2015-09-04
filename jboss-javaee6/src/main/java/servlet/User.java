package servlet;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Named
@RequestScoped
public class User {
	@Size(min=5,max=10)
	private String name;
	@Size(min=5,max=10)
	@Pattern(regexp=".*\\d.*")
	private String passwd;
	@Min(0)
	@Max(150)
	private int age;
	
	private String country;
	
	private Date birthDate;

	/**
	 * @return the birthDay
	 */
	public Date getBirthDay() {
		return birthDate;
	}

	/**
	 * @param birthDay the birthDay to set
	 */
	public void setBirthDay(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String password) {
		this.passwd = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
