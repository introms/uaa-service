package it.itresources.demo.micro.uaaservice.controller.model;

import java.util.Objects;

import javax.validation.constraints.NotNull;

public class UserDto {

    private long id;

    @NotNull(message = "*** INPUT VALIDATION FAILED: username is mandatory!!!!! ***")
    private String username;
    private String role;
    private String roleDescription;
    private String description;


    public UserDto() {
    }

    public UserDto(long id, String username, String role, String roleDescription, String description) {
        this.id = id;
        this.username = username;
        this.role = role;
        this.roleDescription = roleDescription;
        this.description = description;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public UserDto id(long id) {
        this.id = id;
        return this;
    }

    public UserDto username(String username) {
        this.username = username;
        return this;
    }

    public UserDto role(String role) {
        this.role = role;
        return this;
    }

    public UserDto description(String description) {
        this.description = description;
        return this;
    }
    
    

    public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	@Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserDto)) {
            return false;
        }
        UserDto userDto = (UserDto) o;
        return id == userDto.id && Objects.equals(username, userDto.username) && Objects.equals(role, userDto.role) && Objects.equals(description, userDto.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, role, description);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", username='" + getUsername() + "'" +
            ", role='" + getRole() + "'" +
            ", description='" + getDescription() + "'" +
            "}";
    }
    
}