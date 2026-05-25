package com.medisoft.bt01.controller;

import com.medisoft.bt01.service.FlashSaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/flash-sale")
public class FlashSaleController {

    @Autowired
    private FlashSaleService flashSaleService;

    @PostMapping("/apply")
    public String applyDiscount(
            @RequestParam String userId,
            @RequestParam String code
    ) {

        flashSaleService.applyDiscount(userId, code);

        return "Đã xử lý yêu cầu";
    }
}