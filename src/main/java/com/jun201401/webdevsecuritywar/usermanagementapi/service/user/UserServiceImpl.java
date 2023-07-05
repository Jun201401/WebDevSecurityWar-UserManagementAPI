package com.jun201401.webdevsecuritywar.usermanagementapi.service.user;

import com.jun201401.webdevsecuritywar.usermanagementapi.dto.user.PostUserDto;
import com.jun201401.webdevsecuritywar.usermanagementapi.entity.User;
import com.jun201401.webdevsecuritywar.usermanagementapi.repository.user.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    @Transactional
    public User createUser(PostUserDto postUserDto) {
        User user = new User(
                postUserDto.getId(),
                postUserDto.getPassword(),
                postUserDto.getNickname(),
                postUserDto.getEmail()
        );
        return userRepository.saveAndFlush(user);
    }
}