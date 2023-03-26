package ru.berkytteam.shop.shopserver.model.dto

import org.springframework.http.HttpStatus

class HtpErrorDto {
    String message
    HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR
}
