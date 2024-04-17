package com.example.carprice.controler;

import com.example.carprice.dto.AnnounceDto;
import com.example.carprice.entity.Announce;
import com.example.carprice.service.AnnounceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/car")
@RequiredArgsConstructor
public class CarPriceController {
    private final AnnounceService announceService;

    @GetMapping
    public List<Announce> getAllAnnounce() {
        return announceService.getAllAnnounce();
    }

    @GetMapping("/{date}")
    public List<Announce> getAnnouncesByDate(@PathVariable LocalDate date) {
        return announceService.getAnnouncesByDate(date);
    }

    @GetMapping("/filter")
    public List<Announce> getAnnouncesByParam(@RequestParam(required = false) String brand,
                                              @RequestParam(required = false) String color,
                                              @RequestParam(required = false) BigDecimal price,
                                              @RequestParam(required = false) String model) {
        return announceService.getAnnouncesByParam(brand, color, price, model);
    }

    @PostMapping
    public ResponseEntity<Integer> createAnnounce(@RequestBody AnnounceDto announceDto) {
        announceService.createAnnounce(announceDto);
        return ResponseEntity.status(201).build();
    }

    @DeleteMapping("/{id}")
    public void deleteAnnounceById(@PathVariable Integer id) {
        announceService.deleteAnnounceById(id);
    }
}
