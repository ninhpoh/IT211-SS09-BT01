package com.medisoft.bt01.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FlashSaleService {

    private static final Logger logger =
            LoggerFactory.getLogger(FlashSaleService.class);

    public void applyDiscount(String userId, String code) {

        logger.info("Đang xử lý mã: {} cho user: {}", code, userId);

        try {

            if (code == null || code.isEmpty()) {
                throw new IllegalArgumentException("Mã giảm giá rỗng");
            }

            if (code.equals("ERROR")) {
                throw new RuntimeException("Mã giảm giá không hợp lệ");
            }

            logger.info("Áp dụng mã giảm giá thành công cho user: {}", userId);

        } catch (Exception e) {

            logger.error(
                    "Lỗi khi áp dụng mã giảm giá: {} cho user: {}",
                    code,
                    userId,
                    e
            );
        }
    }
}