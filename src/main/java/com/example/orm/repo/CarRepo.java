package com.example.orm.repo;

import com.example.orm.JdbcMapper;
import com.example.orm.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CarRepo {
    private final JdbcClient jdbcClient;
    private final JdbcMapper<Car> mapper = new JdbcMapper<>(Car.class);

    public CarRepo(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<Car> getAllCars() {
        return jdbcClient
                .sql("""
                        select *
                        from cars
                        """)
                .query((rs, n) -> mapper.mapRow(rs))
                .list();
    }
}
