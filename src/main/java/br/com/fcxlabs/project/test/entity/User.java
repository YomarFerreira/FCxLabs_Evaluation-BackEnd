package br.com.fcxlabs.project.test.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name = "user")
public class User {

	@Id
	@JsonProperty(access=JsonProperty.Access.READ_ONLY)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="name", nullable=false, length=100)
	private String name;
	
	@Column(name="login", nullable=false, length=50)
	private String login;
	
	@Column(name="password", nullable=false, length=50)
	private String password;
	
	@Column(name="email", nullable=false, length=150)
	private String email;
	
	@Column(name="phone", nullable=false, length=20)
	private String phone;
	
	@Column(name="cpf", unique=true, nullable=false, length=14)
	private String cpf;
		
	@ApiModelProperty(example = "17/04/1990")
    @JsonFormat(pattern = "dd/MM/yyyy")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
	@Temporal(TemporalType.DATE)
	@Column(name="birth_date", nullable=false)
	private Date birthDate;
	
	@Column(name="mother_name", nullable=false, length=100)
	private String motherName;
	
	@Column(name="status", nullable=false, length=10)
	private String status;
	
	@ApiModelProperty(example = "2022/02/15 22:00:00")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm-300")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
	@Temporal(TemporalType.DATE)
	@Column(name="insert_date", nullable=false)
	private Date insertDate;

	@ApiModelProperty(example = "2022/05/22 22:00:00")
    @JsonFormat(pattern = "yyyy/MM/dd HH:mm-300")
    @JsonSerialize(using = DateSerializer.class)
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
	@Temporal(TemporalType.DATE)
	@Column(name="change_date", nullable=false)
	private Date changeDate;
	
	
	public User(Long id, String name, String login, String password, String email, String phone, String cpf, Date birthDate,
			String motherName, String status, Date insertDate, Date changeDate) {
		super();
		this.id = id;
		this.name = name;
		this.login = login;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.cpf = cpf;
		this.birthDate = birthDate;
		this.motherName = motherName;
		this.status = status;
		this.insertDate = insertDate;
		this.changeDate = changeDate;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() { return id; }
	public String getName() { return name; }
	public String getLogin() { return login; }
	public String getPassword() { return password; }
	public String getEmail() { return email; }
	public String getPhone() { return phone; }
	public String getCpf() { return cpf; }
	public Date getBirthDate() { return birthDate; }
	public String getMotherName() { return motherName; }
	public String getStatus() {	return status; }
	public Date getInsertDate() { return insertDate; }
	public Date getChangeDate() { return changeDate; }

	public void setId(Long id) { this.id = id; }
	public void setName(String name) { this.name = name; }
	public void setLogin(String login) { this.login = login; }
	public void setPassword(String password) { this.password = password; }
	public void setEmail(String email) { this.email = email; }
	public void setPhone(String phone) { this.phone = phone; }
	public void setCpf(String cpf) { this.cpf = cpf; }
	public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }
	public void setMotherName(String motherName) { this.motherName = motherName; }
	public void setStatus(String status) { this.status = status; }
	public void setInsertDate(Date insertDate) { this.insertDate = insertDate; }
	public void setChangeDate(Date changeDate) { this.changeDate = changeDate; }
	
	@Override
	public String toString() {
		return "user [id=" + id + ", name=" + name + ", login=" + login + ", password=" + password + ", email=" + email
				+ ", phone=" + phone + ", cpf=" + cpf + ", birthDate=" + birthDate + ", motherName=" + motherName 
				+ ", status=" + status + ", insertDate=" + insertDate + ", changeDate=" + changeDate + "]";
	}

}
