package ru.berkytteam.shop.shopserver.extension

import io.tswf.groovy.bettergroovy.transforms.extensions.ExtensionMethodsContainer
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import ru.berkytteam.shop.shopserver.model.dto.HttpErrorDto

@ExtensionMethodsContainer
class AdditionalToResponseMethods {

    static <T> ResponseEntity<T> toResponse(Optional<T> self) {
        return toResponse(self.orNull())
    }

    static <T> ResponseEntity<T> toResponse(T self) {
        if (self instanceof Optional) {
            return toResponse(self)
        }

        if (self == null) {
            def responseDto = new HttpErrorDto(
                status: HttpStatus.NOT_FOUND,
                message: "No data found for the request :c"
            )

            def resp =  ResponseEntity.status(HttpStatus.NOT_FOUND).body(responseDto)
            return resp
        }

        return ResponseEntity.ok(self)
    }

}
