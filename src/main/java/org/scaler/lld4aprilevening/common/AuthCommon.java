package org.scaler.lld4aprilevening.common;

import org.scaler.lld4aprilevening.dtos.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AuthCommon {
    private RestTemplate restTemplate;

    public AuthCommon(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    public UserDto validate(String tokenValue){

        ResponseEntity<UserDto> response = restTemplate.getForEntity(
                "http://localhost:4145/users/validate/" + tokenValue,
                UserDto.class
        );

        if(!response.hasBody()){
            // throe exception;
            return null;
        }

        return response.getBody();


    }
}
