package com.pingwit.server.converter;

import com.pingwit.server.entity.Racer;
import org.springframework.stereotype.Component;

//@Mapper(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
@Component
public class RacerConverter {
    public Racer update(Racer source, Racer target) {
        if (source.getName() != null) {
            target.setName(source.getName());
        }

        if (source.getSurname() != null) {
            target.setSurname(source.getSurname());
        }

        if (source.getAge() != null) {
            target.setAge(source.getAge());
        }

        return target;
    }
}
