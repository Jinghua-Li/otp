package com.example.otp.resource;

import javax.validation.Valid;

import com.example.otp.service.OtpService;
import com.example.otp.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/otp")
@Validated
public class OtpController {
    
    @Autowired
    private OtpService otpService;
    
    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity sendOtp(@Valid @RequestBody OtpSendRequest otpSendRequest) {
        otpService.sendOtp(otpSendRequest);
        
        return ResponseEntity.builder()
                .message(Constants.SEND_OTP_TO_PHONE + otpSendRequest.getPhoneNumber())
                .build();
    }
    
    @DeleteMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity verifyOtp(@Valid @RequestBody OtpVerificationRequest otpVerificationRequest) {
        otpService.verifyOtp(otpVerificationRequest);
        
        return ResponseEntity.builder()
                .message(Constants.VERIFY_SUCCESSFULLY).build();
    }
}