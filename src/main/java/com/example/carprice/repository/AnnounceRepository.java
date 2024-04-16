package com.example.carprice.repository;

import com.example.carprice.entity.Announce;
import org.springframework.stereotype.Component;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AnnounceRepository {
    private final Map<Integer, Announce> announces = new HashMap<>();

    // Создание нового объявления
    public void addAnnounce(Announce announce) {
        announces.put(announce.getId(), announce);
    }

    // Получение списка всех объявлений
    public List<Announce> getAllAnnounce() {
        return new ArrayList<>(announces.values());
    }

    // Получение списка объявлений за указанную дату
    public List<Announce> getAnnouncesByDate(LocalDate date) {
        return announces.values().stream().filter(announce -> announce.getDate().equals(date)).toList();
    }

    // Удаление объявления по id
    public void deleteAnnounceById(Integer id) {
        announces.remove(id);
    }
}
