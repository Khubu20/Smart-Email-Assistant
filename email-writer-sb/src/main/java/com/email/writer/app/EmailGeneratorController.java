package com.email.writer.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/email")
@CrossOrigin(origins="*")
public class EmailGeneratorController {

  private final EmailGeneratorService emailGeneratorService;
    @Autowired
    public EmailGeneratorController(EmailGeneratorService emailGeneratorService) {
        this.emailGeneratorService = emailGeneratorService;
    }




    @PostMapping("/generate")
    public ResponseEntity<String> generateEmail(@RequestBody EmailRequest emailRequest){
        System.out.println("Request received: " + emailRequest);
        String response=emailGeneratorService.generateEmailReply(emailRequest);
        System.out.println("Response to return: " + response);
        return ResponseEntity.ok(response);
    }

}
