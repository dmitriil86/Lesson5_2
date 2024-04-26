package com.example.lesson5.interfaces;

import com.example.lesson5.dto.RequestAccountReq;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/corporate-settlement-account")
public interface AccountInterface {

    @ApiResponses
    @PostMapping("/create")
    ResponseEntity<?> createAccount(@Valid @RequestBody RequestAccountReq req);
}
