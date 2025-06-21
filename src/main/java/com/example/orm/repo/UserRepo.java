package com.example.orm.repo;

import com.example.orm.JdbcMapper;
import com.example.orm.entity.User;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository
public class UserRepo {

    private final JdbcClient jdbcClient;
    JdbcMapper<User> mapper = new JdbcMapper<>(User.class);

    public UserRepo(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }

    public List<User> selectionAll() throws SQLException {
        return jdbcClient
                .sql("""
                        SELECT
                            person.id
                            , person.first_name
                            , person.last_name
                            , person.points
                            , person.good_mode
                            , car.id
                            , car.model
                            , car.kw
                            , car.holder_id
                        FROM persons person
                        JOIN cars car ON car.holder_id = person.id
                        WHERE person.id = 4
                        """)
                .query((rs, n) -> mapper.mapRow(rs))
                .list();
    }

}
