package com.example.SportDiaryServer.controller;

import com.example.SportDiaryServer.repository.VersionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class VersionController {
    private final VersionRepository versionRepository;

    @Autowired
    public VersionController(VersionRepository versionRepository) {
        this.versionRepository = versionRepository;
    }

    @RequestMapping(value = "/auth/version", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<Long> onGetVersion(@RequestParam("userId") String userId){
        var version = versionRepository.findByUserId(userId);
        if (version != null) {
            return new ResponseEntity<>(version.getVersion(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(0L, HttpStatus.OK);
        }
    }
}
