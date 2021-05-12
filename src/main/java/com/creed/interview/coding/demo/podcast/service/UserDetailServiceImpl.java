package com.creed.interview.coding.demo.podcast.service;

import com.creed.interview.coding.demo.podcast.model.security.User;
import com.creed.interview.coding.demo.podcast.model.security.UserDetailsImpl;
import com.creed.interview.coding.demo.podcast.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    /**
     * @param userName
     * @return UserDetails - The details from the USER (username, password roles etc)
     *
     * This method is provided by Spring Security to load the user by username
     */

    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        //Getting the user from the database
        Optional<User> user = userRepository.findByUserName(userName);

        //If we are not able to find any user matching the provided userName we are returning and exception
        user.orElseThrow(() ->new UsernameNotFoundException(userName + "NOT FOUND"));
        return user.map(UserDetailsImpl::new).get();
    }
}
