package com.wordviz.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User implements Serializable {

	private static final long serialVersionUID = -3177995515406462034L;

	@Id
	@GeneratedValue
	@Column(name = "userId")
	private Integer userId;
	
	@Size(max = 25)
	@NotNull
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Column(name = "password")
	private Integer password;
	
	@Size(max = 25)
	@Column(name = "displayName")
	private String displayName;
	
	public User() {
		super();
		this.username = "";
		this.password = 0;
	}

	public User(String username, Integer password) {
		this.username = username;
		this.password = password;
		this.displayName = username;
	}

	public User(String username, Integer password, String displayName) {
		this.username = username;
		this.password = password;
		this.displayName = displayName;
	}

	public User(Integer userId, String username, Integer password, String displayName) {
		this.userId = userId;
		this.username = username;
		this.password = password;
		this.displayName = displayName;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getPassword() {
		return password;
	}

	public void setPassword(Integer password) {
		this.password = password;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
	@Override
	public String toString() {
		return "User [userId=" + userId + ", username=" + username + ", password=" + password + ", displayName="
				+ displayName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((displayName == null) ? 0 : displayName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (displayName == null) {
			if (other.displayName != null)
				return false;
		} else if (!displayName.equals(other.displayName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userId == null) {
			if (other.userId != null)
				return false;
		} else if (!userId.equals(other.userId))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}
}
