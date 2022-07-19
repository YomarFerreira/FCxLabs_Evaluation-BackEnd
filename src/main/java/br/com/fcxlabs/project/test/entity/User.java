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
@Table(name = "\"user\"")
public class User {

	@Id
	@JsonProperty(access=JsonProperty.Access.READ_ONLY)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ApiModelProperty(example = "User Name")
	@Column(name="name", nullable=false, length=100)
	private String name;
	
	@ApiModelProperty(example = "LOGIN")
	@Column(name="login", nullable=false, length=50, unique=true)
	private String login;
	
	@ApiModelProperty(example = "P@~$w-Or_D#09")
	@Column(name="password", nullable=false, length=50)
	private String password;
	
	@ApiModelProperty(example = "email@provider.com")
	@Column(name="email", nullable=false, length=150, unique=true)
	private String email;
	
	@ApiModelProperty(example = "(99)98765-4321")
	@Column(name="phone", nullable=false, length=20)
	private String phone;
	
	@ApiModelProperty(example = "12345678909")
	@Column(name="cpf", nullable=false, length=14, unique=true)
	private String cpf;
		
	@ApiModelProperty(example = "1990-04-17")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
	@Temporal(TemporalType.DATE)
	@Column(name="birth_date", columnDefinition="DATE", nullable=false)
	private Date birthDate;
	
	@ApiModelProperty(example = "User's mother name")
	@Column(name="mother_name", nullable=false, length=100)
	private String motherName;
	
	@ApiModelProperty(example = "ACTIVE or INACTIVE")
	@Column(name="status", nullable=false, length=10)
	private String status;
	
	@ApiModelProperty(example = "2022-02-15 13:10-0300")
	@JsonFormat(pattern = "yyyy-MM-dd HH:mmZ")
	@JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="insert_date", columnDefinition="DATETIME", nullable=false)
	private Date insertDate;

	@ApiModelProperty(example = "2022-05-22 09:50-0300")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mmZ")
    @JsonDeserialize(using = DateDeserializers.DateDeserializer.class)
    @JsonSerialize(using = DateSerializer.class)
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="change_date", columnDefinition="DATETIME")
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
		super();
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
