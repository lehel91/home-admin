package hu.lmsystems.homeadmin.authentication.service;

public interface SecurityService {

	String findLoggedInUsername();

    void autoLogin(String username, String password);
}
