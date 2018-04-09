package com.mindtree.cgis.services;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mindtree.cgis.Constants;
import com.mindtree.cgis.SecurityConsts;
import com.mindtree.cgis.daoimp.cgisdb.UserDAO;
import com.mindtree.cgis.entity.CGISUser;

import org.springframework.security.core.userdetails.User;

@Service("securityUserServiceImpl")
public class SecurityUserServiceImpl implements SecurityUserService {
	@Autowired
	public UserDAO userDAO;
	
	static final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	/*public UserDetails loadUserByUsername(String empId)
			throws UsernameNotFoundException {
		System.out.println("Called auth provider...");
		final User user = getUserByID(empId);
		
		if(user == null){
			throw new UsernameNotFoundException("Invali user: "+empId);
		}
		else{
			UserDetails details = new UserDetails() {
				
				public boolean isEnabled() {
					return user.getIsActive();
				}
				
				public boolean isCredentialsNonExpired() {
					return false;
				}
				
				public boolean isAccountNonLocked() {
					return false;
				}
				
				public boolean isAccountNonExpired() {
					return false;
				}
				
				public String getUsername() {
					return user.getName();
				}
				
				public String getPassword() {
					return user.getPassword();
				}
				
				
				//@Override
				public Collection<? extends GrantedAuthority> getAuthorities(){
	                List<SimpleGrantedAuthority> auths = new java.util.ArrayList<SimpleGrantedAuthority>();
	                auths.add(new SimpleGrantedAuthority("Admin"));
	                return auths;
	            }
			};
		}
		return null;
	}*/

	@Override
    public UserDetails loadUserByUsername(String empId) throws UsernameNotFoundException {
        final CGISUser cgisUser = getUserByID(empId);
        
        //check if this user with this username exist, if not, throw an exception
        // and stop the login process
        if (cgisUser == null) {
            throw new UsernameNotFoundException("User details not found with this username: " + empId);
        }

        String password = cgisUser.getPassword();

        List<GrantedAuthority> authList = getAuthorities(cgisUser);

        //get the encoded password
        String encodedPassword = passwordEncoder.encode(password);

        User user = new User(cgisUser.getName(), encodedPassword, authList);
        System.out.println("USER: "+user);
        System.out.println("\n\n USER authorities: "+user.getAuthorities());

        return user;
    }
	 
	@Transactional(value = "cgisDbTransactionManager")
	public CGISUser getUserByID(String empId) {
		return userDAO.get(empId);
	}
	
	private List<GrantedAuthority> getAuthorities(CGISUser cgisUser) {
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
        authList.add(new SimpleGrantedAuthority(Constants.ROLE_USER));
        String userRole = cgisUser.getCgisRole();
        if(!userRole.equals(Constants.ROLE_USER)){
        	authList.add(new SimpleGrantedAuthority(userRole));
        }
        return authList;
    }
}
