package com.gachonproject.movementservice.domain.image.controller;

import com.gachonproject.movementservice.domain.image.util.ImageUtil;
import com.gachonproject.movementservice.global.common.response.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.gachonproject.movementservice.domain.image.controller.SuccessMessage.PRESIGNED_URL_GENERATE_SUCCESS;

@RestController
@RequiredArgsConstructor
public class ImageController {

    private final ImageUtil imageUtil;

    @GetMapping("/image/presigned-url")
    public ApiResponse<String> getPreSignedUrl(@RequestParam String fileName) {
        String preSignedUrl = imageUtil.generateUrl(fileName);

        return ApiResponse.response(HttpStatus.OK, PRESIGNED_URL_GENERATE_SUCCESS.getMessage(), preSignedUrl);
    }

}
