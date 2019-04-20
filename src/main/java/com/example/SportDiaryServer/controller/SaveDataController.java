package com.example.SportDiaryServer.controller;

import com.example.SportDiaryServer.dto.EditDto;
import com.example.SportDiaryServer.entity.editEntity.Time;
import com.example.SportDiaryServer.repository.editRepository.EditRepository;
import com.example.SportDiaryServer.service.conversion.EntityDtoConversionService;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/save")
public class SaveDataController {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final EditRepository<Time> timeRepository;
    private final EntityDtoConversionService conversionService;

    @Autowired
    public SaveDataController(EntityDtoConversionService conversionService, EditRepository<Time> timeRepository) {
        this.conversionService = conversionService;
        this.timeRepository = timeRepository;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity onInsert(@RequestParam("table") String table,
                                   @RequestParam("data") String data) {
        try {
            switch (table) {
                case "Time":
                    timeRepository.save(conversionService.convertDtoToEntity(objectMapper.readValue(data, EditDto.class)));
            }
            return new ResponseEntity(HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
