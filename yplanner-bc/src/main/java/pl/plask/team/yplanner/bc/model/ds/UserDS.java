package pl.plask.team.yplanner.bc.model.ds;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import pl.plask.team.yplanner.bc.model.ds.helper.YesNoEnum;

@Entity
@Table(name = "YPL_USERS")
public class UserDS implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 929916685441550562L;

	private Long id;
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String email;
	private YesNoEnum admin;

	@Id
	@SequenceGenerator(name = "yplUsersSeq", sequenceName = "YPL_USERS_SEQ")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "yplUsersSeq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "FIRST_NAME")
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name = "LAST_NAME")
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name = "LOGIN")
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "ADMIN")
	@Enumerated(EnumType.STRING)
	public YesNoEnum getAdmin() {
		return admin;
	}

	public void setAdmin(YesNoEnum admin) {
		this.admin = admin;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDS other = (UserDS) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
