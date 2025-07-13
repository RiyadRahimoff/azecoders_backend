package com.azecoders.community.service.concrete;

import com.azecoders.community.dao.entity.UserEntity;
import com.azecoders.community.dao.repository.UserRepository;
import com.azecoders.community.model.request.create.CreateCompleteProfileRequest;
import com.azecoders.community.service.abstraction.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceHandler implements UserService {
    private final UserRepository userRepository;

    @Override
    public void completeProfile(CreateCompleteProfileRequest profileRequest, String email) {
        UserEntity user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found!"));
        user.setBio(profileRequest.getBio());
        user.setProfilePhoto(profileRequest.getProfilePhoto());
        user.setProfession(profileRequest.getProfession());
        user.setProfileCompleted(true);
        userRepository.save(user);
    }
}
