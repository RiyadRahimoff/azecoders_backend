package com.azecoders.community.service.abstraction;

import com.azecoders.community.model.request.create.CreateCompleteProfileRequest;
import com.azecoders.community.model.request.create.CreateRegisterRequest;

public interface UserService {
    void completeProfile(CreateCompleteProfileRequest profileRequest, String email);
}
