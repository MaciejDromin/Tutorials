package pl.mlisowski.testing.example.application;

import org.springframework.stereotype.Service;

@Service
public class DummyService {

    public String dummy() {
        return "Hello!";
    }
}
