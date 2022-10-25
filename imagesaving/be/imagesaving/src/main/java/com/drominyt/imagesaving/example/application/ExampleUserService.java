package com.drominyt.imagesaving.example.application;

import com.drominyt.imagesaving.example.application.port.ExampleUserRepository;
import com.drominyt.imagesaving.example.domain.ExampleUserFactory;
import com.drominyt.imagesaving.example.domain.dto.ExampleUserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExampleUserService {

    private final ExampleUserRepository exampleUserRepository;
    private final ExampleUserFactory exampleUserFactory;

    public ExampleUserDto createUser(ExampleUserDto exampleUserDto) {
        return exampleUserFactory.to(exampleUserRepository.save(exampleUserFactory.from(exampleUserDto)));
    }

    public List<ExampleUserDto> getUsers() {
        return exampleUserRepository.findAll().stream()
                .map(exampleUserFactory::to)
                .toList();
    }

}
