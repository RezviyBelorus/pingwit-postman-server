package com.pingwit.server.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Racer implements Comparable<Racer> {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;

    @Override
    public int compareTo(Racer o) {
        return this.id - o.id;
    }
}
