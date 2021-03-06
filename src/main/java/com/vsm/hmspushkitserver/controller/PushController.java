package com.vsm.hmspushkitserver.controller;

import com.vsm.hmspushkitserver.dto.PushRequest;
import com.vsm.hmspushkitserver.dto.PushResponse;
import com.vsm.hmspushkitserver.service.PushService;
import com.vsm.hmspushkitserver.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PushController {
    @Autowired
    private TokenService tokenService;
    @Autowired
    private PushService pushService;


    @RequestMapping(value = "/getToken",
            method = RequestMethod.GET,
            produces = "application/json"
    )
    public ResponseEntity<PushResponse> getToken() {
        return new ResponseEntity<>(tokenService.getTransactionToken(), HttpStatus.OK);
    }

    @RequestMapping(value = "/sendNotification",
            method = RequestMethod.POST,
            consumes = "application/json",
            produces = "application/json"
    )
    public ResponseEntity<PushResponse> sendNotification(@RequestBody PushRequest request) {
        return new ResponseEntity<>(pushService.sendNotification(request), HttpStatus.OK);
    }

}
