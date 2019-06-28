package it.itresources.demo.micro.uaaservice.service;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import it.itresources.demo.micro.uaaservice.controller.model.UserDto;
import it.itresources.demo.micro.uaaservice.domain.Description;
import it.itresources.demo.micro.uaaservice.domain.Role;
import it.itresources.demo.micro.uaaservice.domain.User;
import it.itresources.demo.micro.uaaservice.repo.DescriptionRepository;
import it.itresources.demo.micro.uaaservice.repo.RoleRepository;
import it.itresources.demo.micro.uaaservice.repo.UserRepository;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final DescriptionRepository descriptionRepository;
    private final RoleRepository roleRepository;

    @Autowired
    public UserService(UserRepository userRepository,
        DescriptionRepository descriptionRepository,
        RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.descriptionRepository = descriptionRepository;
        this.roleRepository = roleRepository;
    }

    public UserDto create(UserDto userDto) {
        logger.info("************************************************************");
        logger.info("****************** Request to save user ********************");
        logger.info("************************************************************");

        Description description = null;
        if (!StringUtils.isEmpty(userDto.getDescription())) {
            Description descEntity = new Description();
            descEntity.setDesccriptionText(userDto.getDescription());
            description = descriptionRepository.save(descEntity);
        }

        Role role = null;
        if (!StringUtils.isEmpty(userDto.getRole())) {
            role = roleRepository.findOneByName(userDto.getRole());
        }

        // Create Entity
        User user = new User(null, userDto.getUsername(), description, role);

        // call repo
        User newUser = userRepository.save(user);

        userDto.setId(newUser.getId());

        return userDto;
    }
    
    public List<UserDto> getAll() {
        List<UserDto> userDtos = 
            userRepository.findAll()
                .stream()
                    .map(u -> new UserDto(u.getId(), u.getUsername(), u.getRole().getName(), u.getDescription().getDesccriptionText()))
                        .collect(Collectors.toList());

        return userDtos;
    }
}