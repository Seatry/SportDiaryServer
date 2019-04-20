package com.example.SportDiaryServer.controller;

import com.example.SportDiaryServer.dto.EditDto;
import com.example.SportDiaryServer.entity.editEntity.*;
import com.example.SportDiaryServer.repository.*;
import com.example.SportDiaryServer.service.conversion.EntityDtoConversionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

import static com.example.SportDiaryServer.enums.Table.*;

@RestController
@RequestMapping("/save")
public class SaveDataController {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final EditRepository<Time> timeRepository;
    private final EditRepository<Aim> aimRepository;
    private final EditRepository<Block> blockRepository;
    private final EditRepository<Borg> borgRepository;
    private final EditRepository<Camp> campRepository;
    private final EditRepository<Competition> competitionRepository;
    private final EditRepository<Equipment> equipmentRepository;
    private final EditRepository<Exercise> exerciseRepository;
    private final EditRepository<Importance> importanceRepository;
    private final EditRepository<RestPlace> restPlaceRepository;
    private final EditRepository<Stage> stageRepository;
    private final EditRepository<Style> styleRepository;
    private final EditRepository<Tempo> tempoRepository;
    private final EditRepository<Test> testRepository;
    private final EditRepository<TrainingPlace> trainingPlaceRepository;
    private final EditRepository<Type> typeRepository;
    private final EditRepository<Zone> zoneRepository;
    private final CompetitionToImportanceRepository competitionToImportanceRepository;
    private final DayRepository dayRepository;
    private final DayToTestRepository dayToTestRepository;
    private final DreamAnswerRepository dreamAnswerRepository;
    private final DreamQuestionRepository dreamQuestionRepository;
    private final HeartRateRepository heartRateRepository;
    private final RestRepository restRepository;
    private final SanAnswerRepository sanAnswerRepository;
    private final SanQuestionRepository sanQuestionRepository;
    private final SeasonPlanRepository seasonPlanRepository;
    private final TrainingExerciseRepository trainingExerciseRepository;
    private final TrainingRepository trainingRepository;
    private final TrainingsToAimsRepository trainingsToAimsRepository;
    private final TrainingsToEquipmentsRepository trainingsToEquipmentsRepository;
    private final EntityDtoConversionService conversionService;

    @Autowired
    public SaveDataController(EditRepository<Competition> competitionRepository, EntityDtoConversionService conversionService, EditRepository<Time> timeRepository,
                              EditRepository<Aim> aimRepository, EditRepository<Block> blockRepository, EditRepository<Borg> borgRepository,
                              EditRepository<Camp> campRepository, EditRepository<Equipment> equipmentRepository, EditRepository<Exercise> exerciseRepository,
                              EditRepository<Importance> importanceRepository, EditRepository<RestPlace> restPlaceRepository,
                              EditRepository<Stage> stageRepository, EditRepository<Style> styleRepository, EditRepository<Tempo> tempoRepository,
                              EditRepository<Test> testRepository, EditRepository<TrainingPlace> trainingPlaceRepository, EditRepository<Type> typeRepository,
                              EditRepository<Zone> zoneRepository, CompetitionToImportanceRepository competitionToImportanceRepository, DayRepository dayRepository,
                              DayToTestRepository dayToTestRepository, DreamAnswerRepository dreamAnswerRepository,
                              DreamQuestionRepository dreamQuestionRepository, HeartRateRepository heartRateRepository,
                              RestRepository restRepository, SanAnswerRepository sanAnswerRepository, SanQuestionRepository sanQuestionRepository,
                              SeasonPlanRepository seasonPlanRepository, TrainingExerciseRepository trainingExerciseRepository,
                              TrainingRepository trainingRepository, TrainingsToAimsRepository trainingsToAimsRepository,
                              TrainingsToEquipmentsRepository trainingsToEquipmentsRepository) {
        this.competitionRepository = competitionRepository;
        this.conversionService = conversionService;
        this.timeRepository = timeRepository;
        this.aimRepository = aimRepository;
        this.blockRepository = blockRepository;
        this.borgRepository = borgRepository;
        this.campRepository = campRepository;
        this.equipmentRepository = equipmentRepository;
        this.exerciseRepository = exerciseRepository;
        this.importanceRepository = importanceRepository;
        this.restPlaceRepository = restPlaceRepository;
        this.stageRepository = stageRepository;
        this.styleRepository = styleRepository;
        this.tempoRepository = tempoRepository;
        this.testRepository = testRepository;
        this.trainingPlaceRepository = trainingPlaceRepository;
        this.typeRepository = typeRepository;
        this.zoneRepository = zoneRepository;
        this.competitionToImportanceRepository = competitionToImportanceRepository;
        this.dayRepository = dayRepository;
        this.dayToTestRepository = dayToTestRepository;
        this.dreamAnswerRepository = dreamAnswerRepository;
        this.dreamQuestionRepository = dreamQuestionRepository;
        this.heartRateRepository = heartRateRepository;
        this.restRepository = restRepository;
        this.sanAnswerRepository = sanAnswerRepository;
        this.sanQuestionRepository = sanQuestionRepository;
        this.seasonPlanRepository = seasonPlanRepository;
        this.trainingExerciseRepository = trainingExerciseRepository;
        this.trainingRepository = trainingRepository;
        this.trainingsToAimsRepository = trainingsToAimsRepository;
        this.trainingsToEquipmentsRepository = trainingsToEquipmentsRepository;
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity onInsert(@RequestParam("table") String table,
                                   @RequestParam("data") String data) {
        try {
            switch (table) {
                case TIME:
                    timeRepository.save(conversionService.convertDtoToEntityTime(objectMapper.readValue(data, EditDto.class)));
            }
            return new ResponseEntity(HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
