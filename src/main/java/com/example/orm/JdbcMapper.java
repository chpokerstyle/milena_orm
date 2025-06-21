package com.example.orm;

import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcMapper<T> {

    private final Class<T> type;

    public JdbcMapper(Class<T> type) {
        this.type = type;
    }

    public T mapRow(ResultSet resultSet) throws SQLException {
        T instance = null;
        try {
            instance = type.getDeclaredConstructor().newInstance();
            for (Field field : type.getDeclaredFields()) {
                field.setAccessible(true);
                String columnName = field.isAnnotationPresent(Column.class)
                        ? field.getAnnotation(Column.class).name()
                        : field.getName();
                Object value = resultSet.getObject(columnName);
                field.set(instance, value);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return instance;
    }


}

