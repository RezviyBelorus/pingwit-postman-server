package com.pingwit.server.repository;

import com.pingwit.server.converter.RacerConverter;
import com.pingwit.server.entity.Racer;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

@Repository
@RequiredArgsConstructor
public class RacerRepository {
    private final RacerConverter racerConverter;

    private static final Set<Racer> RACERS = new TreeSet<>();

    private Integer idSeq;

    @PostConstruct
    private void init() {
        RACERS.add(new Racer(1, "Michael", "Schumacher", 45));
        RACERS.add(new Racer(2, "Rubens ", "Barrichello", 52));
        RACERS.add(new Racer(3, "Lewis", "Hamilton", 39));

        idSeq = RACERS.size() + 1;
    }

    public Set<Racer> findAll(RacerOrdering racerOrdering) {
        if (RacerOrdering.DESC == racerOrdering) {
            TreeSet<Racer> reversedRacers = new TreeSet<>(Comparator.reverseOrder());
            reversedRacers.addAll(RACERS);
            return reversedRacers;
        }

        return RACERS;
    }

    public Racer save(Racer racer) {
        if (racer.getId() != null) {
            throw new IllegalArgumentException("New racer shouldn't have an id");
        }

        racer.setId(idSeq);
        idSeq++;

        RACERS.add(racer);

        return racer;
    }

    public Racer delete(Integer id) {
        Racer toDelete = RACERS.stream()
                .filter(racer -> racer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("User with id doesn't exist: " + id));

        RACERS.remove(toDelete);
        return toDelete;
    }

    public Racer findOne(Integer id) {
        return RACERS.stream()
                .filter(racer -> racer.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Can't find racer with id: " + id));
    }

    public Racer update(Racer dto) {
        return RACERS.stream()
                .filter(racer -> racer.getId().equals(dto.getId()))
                .findFirst()
                .map(racer -> racerConverter.update(dto, racer))
                .orElseThrow(() -> new IllegalArgumentException("[UPDATE] Can't find racer with id: " + dto.getId()));
    }

}
