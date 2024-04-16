package com.example.carprice.service;

import com.example.carprice.dto.AnnounceDto;
import com.example.carprice.entity.Announce;
import com.example.carprice.repository.AnnounceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnnounceService {
    private final AnnounceRepository announceRepository;
    private static Integer id = -1;

    public void createAnnounce(AnnounceDto dto) {
        String brand = dto.getBrand() == null ? "" : dto.getBrand();
        String color = dto.getColor() == null ? "" : dto.getColor();
        BigDecimal price = dto.getPrice() == null ? BigDecimal.ZERO : dto.getPrice();
        String model = dto.getModel() == null ? "" : dto.getModel();
        announceRepository.addAnnounce(new Announce(generateId(), brand, color,
                        price, model, LocalDate.now()));
    }

    public List<Announce> getAllAnnounce() {
        return announceRepository.getAllAnnounce();
    }

    public List<Announce> getAnnouncesByDate(LocalDate date) {
        return announceRepository.getAnnouncesByDate(date);
    }

    public void deleteAnnounceById(Integer id) {
        announceRepository.deleteAnnounceById(id);
    }

    private Integer generateId() {
        return id += 1;
    }

    // Поиск объявлений по сочетанию параметров
    public List<Announce> getAnnouncesByParam(String brand, String color, BigDecimal price, String model) {
        List<Announce> announces = announceRepository.getAllAnnounce();
        List<Announce> result = new ArrayList<>();
        for (Announce announce : announces)
        {
            if ((brand == null || announce.getBrand().equals(brand)) &&
                    (color == null || announce.getColor().equals(color)) &&
                    (price == null || announce.getPrice().equals(price)) &&
                    (model == null || announce.getModel().equals(model))) {
                result.add(announce);
            }
        }
        return result;
    }
}
