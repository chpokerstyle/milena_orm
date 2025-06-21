package com.example.orm;

import com.example.orm.entity.Car;
import com.example.orm.entity.User;
import com.example.orm.repo.CarRepo;
import com.example.orm.repo.UserRepo;
import jakarta.websocket.server.PathParam;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/test")
public class Controller {
    private final UserRepo userRepo;
    private final CarRepo carRepo;

    public Controller(UserRepo userRepo, CarRepo carRepo) {
        this.userRepo = userRepo;
        this.carRepo = carRepo;
    }

    @GetMapping("/persons/")
    public List<User> getUser() throws SQLException {
        return userRepo.selectionAll();
    }

    @GetMapping("/cars")
    public List<Car> getAlCars() throws SQLException {
        return carRepo.getAllCars();
    }
}
