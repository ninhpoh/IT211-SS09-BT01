package com.medisoft.bt01.controller;

import com.medisoft.bt01.service.FlashSaleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/flash-sale")
public class FlashSaleController {

    private static final Logger logger = LoggerFactory.getLogger(FlashSaleController.class);

    private final FlashSaleService flashSaleService;

    public FlashSaleController(FlashSaleService flashSaleService) {
        this.flashSaleService = flashSaleService;
    }

    @PostMapping("/apply")
    public ResponseEntity<Map<String, Object>> applyDiscount(
            @RequestParam String userId,
            @RequestParam String code) {

        logger.info("Nhận request áp dụng mã giảm giá. userId: {}, code: {}", userId, code);

        try {
            flashSaleService.applyDiscount(userId, code);
            return ResponseEntity.ok(Map.of(
                    "success", true,
                    "message", "Áp dụng mã giảm giá thành công!",
                    "userId", userId,
                    "code", code
            ));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "success", false,
                    "message", e.getMessage()
            ));
        } catch (RuntimeException e) {
            return ResponseEntity.internalServerError().body(Map.of(
                    "success", false,
                    "message", e.getMessage()
            ));
        }
    }
}