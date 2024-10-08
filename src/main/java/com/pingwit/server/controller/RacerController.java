package com.pingwit.server.controller;

import com.pingwit.server.entity.Racer;
import com.pingwit.server.repository.RacerOrdering;
import com.pingwit.server.repository.RacerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/racer")
@RequiredArgsConstructor
public class RacerController {

    private final RacerRepository racerRepository;

    @GetMapping("/{id}")
    public Racer findOne(@PathVariable Integer id) {
        return racerRepository.findOne(id);
    }

    @GetMapping("/all")
    public Set<Racer> findAll(@RequestParam @Nullable RacerOrdering sort) {
        return racerRepository.findAll(sort);
    }

    @PostMapping("/save")
    public Racer save(@RequestBody Racer racer) {
        return racerRepository.save(racer);
    }

    @PutMapping("/update")
    public Racer update(@RequestBody Racer racer) {
        return racerRepository.update(racer);
    }

    @DeleteMapping("/delete/{id}")
    public Racer delete(@PathVariable Integer id) {
        return racerRepository.delete(id);
    }

}
