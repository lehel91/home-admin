package hu.lmsystems.homeadmin.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import hu.lmsystems.homeadmin.annotations.PasswordMatches;
import hu.lmsystems.homeadmin.annotations.ValidEmail;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@PasswordMatches
public class UserDto {
    @NotNull
    @NotEmpty
    private String firstName;
     
    @NotNull
    @NotEmpty
    private String lastName;
     
    @NotNull
    @NotEmpty
    private String password;
    private String matchingPassword;
     
    @ValidEmail
    @NotNull
    @NotEmpty
    private String email;

}
