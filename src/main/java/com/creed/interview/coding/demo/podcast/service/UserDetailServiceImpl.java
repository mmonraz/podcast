package com.creed.interview.coding.demo.podcast.service;

import com.creed.interview.coding.demo.podcast.model.security.User;
import com.creed.interview.coding.demo.podcast.model.security.UserDetailsImpl;
import com.creed.interview.coding.demo.podcast.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);

        user.orElseThrow(() ->new UsernameNotFoundException(userName + "NOT FOUND"));
        return user.map(UserDetailsImpl::new).get();
    }
}
