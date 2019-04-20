package com.example.SportDiaryServer.controller;

import com.example.SportDiaryServer.dto.*;
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

    @RequestMapping(value = {"/insert", "/update"}, method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity onInsertAndUpdate(@RequestParam("table") String table,
                                   @RequestParam("data") String data) {
        try {
            switch (table) {
                case TIME:
                    timeRepository.save(conversionService.convertDtoToEntityTime(objectMapper.readValue(data, EditDto.class)));
                    break;
                case AIM:
                    aimRepository.save(conversionService.convertDtoToEntityAim(objectMapper.readValue(data, EditDto.class)));
                    break;
                case BLOCK:
                    blockRepository.save(conversionService.convertDtoToEntityBlock(objectMapper.readValue(data, EditDto.class)));
                    break;
                case BORG:
                    borgRepository.save(conversionService.convertDtoToEntityBorg(objectMapper.readValue(data, EditDto.class)));
                    break;
                case CAMP:
                    campRepository.save(conversionService.convertDtoToEntityCamp(objectMapper.readValue(data, EditDto.class)));
                    break;
                case COMPETITION:
                    competitionRepository.save(conversionService.convertDtoToEntityCompetition(objectMapper.readValue(data, EditDto.class)));
                    break;
                case EQUIPMENT:
                    equipmentRepository.save(conversionService.convertDtoToEntityEquipment(objectMapper.readValue(data, EditDto.class)));
                    break;
                case EXERCISE:
                    exerciseRepository.save(conversionService.convertDtoToEntityExercise(objectMapper.readValue(data, EditDto.class)));
                    break;
                case IMPORTANCE:
                    importanceRepository.save(conversionService.convertDtoToEntityImportance(objectMapper.readValue(data, EditDto.class)));
                    break;
                case REST_PLACE:
                    restPlaceRepository.save(conversionService.convertDtoToEntityRestPlace(objectMapper.readValue(data, EditDto.class)));
                    break;
                case STAGE:
                    stageRepository.save(conversionService.convertDtoToEntityStage(objectMapper.readValue(data, EditDto.class)));
                    break;
                case STYLE:
                    styleRepository.save(conversionService.convertDtoToEntityStyle(objectMapper.readValue(data, EditDto.class)));
                    break;
                case TEMPO:
                    tempoRepository.save(conversionService.convertDtoToEntityTempo(objectMapper.readValue(data, EditDto.class)));
                    break;
                case TEST:
                    testRepository.save(conversionService.convertDtoToEntityTest(objectMapper.readValue(data, EditDto.class)));
                    break;
                case TRAINING_PLACE:
                    trainingPlaceRepository.save(conversionService.convertDtoToEntityTrainingPlace(objectMapper.readValue(data, EditDto.class)));
                    break;
                case TYPE:
                    typeRepository.save(conversionService.convertDtoToEntityType(objectMapper.readValue(data, EditDto.class)));
                    break;
                case ZONE:
                    zoneRepository.save(conversionService.convertDtoToEntityZone(objectMapper.readValue(data, EditDto.class)));
                    break;
                case COMPETITION_TO_IMPORTANCE:
                    competitionToImportanceRepository.save(conversionService.convertDtoToEntity(objectMapper.readValue(data, CompetitionToImportanceDto.class)));
                    break;
                case DAY:
                    dayRepository.save(conversionService.convertDtoToEntity(objectMapper.readValue(data, DayDto.class)));
                    break;
                case DAY_TO_TEST:
                    dayToTestRepository.save(conversionService.convertDtoToEntity(objectMapper.readValue(data, DayToTestDto.class)));
                    break;
                case DREAM_ANSWER:
                    dreamAnswerRepository.save(conversionService.convertDtoToEntity(objectMapper.readValue(data, DreamAnswerDto.class)));
                    break;
                case DREAM_QUESTION:
                    dreamQuestionRepository.save(conversionService.convertDtoToEntity(objectMapper.readValue(data, DreamQuestionDto.class)));
                    break;
                case SAN_ANSWER:
                    sanAnswerRepository.save(conversionService.convertDtoToEntity(objectMapper.readValue(data, SanAnswerDto.class)));
                    break;
                case SAN_QUESTION:
                    sanQuestionRepository.save(conversionService.convertDtoToEntity(objectMapper.readValue(data, SanQuestionDto.class)));
                    break;
                case HEART_RATE:
                    heartRateRepository.save(conversionService.convertDtoToEntity(objectMapper.readValue(data, HeartRateDto.class)));
                    break;
                case REST:
                    restRepository.save(conversionService.convertDtoToEntity(objectMapper.readValue(data, RestDto.class)));
                    break;
                case SEASON_PLAN:
                    seasonPlanRepository.save(conversionService.convertDtoToEntity(objectMapper.readValue(data, SeasonPlanDto.class)));
                    break;
                case TRAINING:
                    trainingRepository.save(conversionService.convertDtoToEntity(objectMapper.readValue(data, TrainingDto.class)));
                    break;
                case TRAINING_EXERICSE:
                    trainingExerciseRepository.save(conversionService.convertDtoToEntity(objectMapper.readValue(data, TrainingExerciseDto.class)));
                    break;
                case TRAININGS_TO_AIMS:
                    trainingsToAimsRepository.save(conversionService.convertDtoToEntity(objectMapper.readValue(data, TrainingsToAimsDto.class)));
                    break;
                case TRAININGS_TO_EQUIPMENTS:
                    trainingsToEquipmentsRepository.save(conversionService.convertDtoToEntity(objectMapper.readValue(data, TrainingsToEquipmentsDto.class)));
                    break;
            }
            return new ResponseEntity(HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity onDelete(@RequestParam("table") String table,
                                   @RequestParam("data") String data) {
        try {
            switch (table) {
                case TIME:
                    timeRepository.delete(conversionService.convertDtoToEntityTime(objectMapper.readValue(data, EditDto.class)));
                    break;
                case AIM:
                    aimRepository.delete(conversionService.convertDtoToEntityAim(objectMapper.readValue(data, EditDto.class)));
                    break;
                case BLOCK:
                    blockRepository.delete(conversionService.convertDtoToEntityBlock(objectMapper.readValue(data, EditDto.class)));
                    break;
                case BORG:
                    borgRepository.delete(conversionService.convertDtoToEntityBorg(objectMapper.readValue(data, EditDto.class)));
                    break;
                case CAMP:
                    campRepository.delete(conversionService.convertDtoToEntityCamp(objectMapper.readValue(data, EditDto.class)));
                    break;
                case COMPETITION:
                    competitionRepository.delete(conversionService.convertDtoToEntityCompetition(objectMapper.readValue(data, EditDto.class)));
                    break;
                case EQUIPMENT:
                    equipmentRepository.delete(conversionService.convertDtoToEntityEquipment(objectMapper.readValue(data, EditDto.class)));
                    break;
                case EXERCISE:
                    exerciseRepository.delete(conversionService.convertDtoToEntityExercise(objectMapper.readValue(data, EditDto.class)));
                    break;
                case IMPORTANCE:
                    importanceRepository.delete(conversionService.convertDtoToEntityImportance(objectMapper.readValue(data, EditDto.class)));
                    break;
                case REST_PLACE:
                    restPlaceRepository.delete(conversionService.convertDtoToEntityRestPlace(objectMapper.readValue(data, EditDto.class)));
                    break;
                case STAGE:
                    stageRepository.delete(conversionService.convertDtoToEntityStage(objectMapper.readValue(data, EditDto.class)));
                    break;
                case STYLE:
                    styleRepository.delete(conversionService.convertDtoToEntityStyle(objectMapper.readValue(data, EditDto.class)));
                    break;
                case TEMPO:
                    tempoRepository.delete(conversionService.convertDtoToEntityTempo(objectMapper.readValue(data, EditDto.class)));
                    break;
                case TEST:
                    testRepository.delete(conversionService.convertDtoToEntityTest(objectMapper.readValue(data, EditDto.class)));
                    break;
                case TRAINING_PLACE:
                    trainingPlaceRepository.delete(conversionService.convertDtoToEntityTrainingPlace(objectMapper.readValue(data, EditDto.class)));
                    break;
                case TYPE:
                    typeRepository.delete(conversionService.convertDtoToEntityType(objectMapper.readValue(data, EditDto.class)));
                    break;
                case ZONE:
                    zoneRepository.delete(conversionService.convertDtoToEntityZone(objectMapper.readValue(data, EditDto.class)));
                    break;
                case COMPETITION_TO_IMPORTANCE:
                    competitionToImportanceRepository.delete(conversionService.convertDtoToEntity(objectMapper.readValue(data, CompetitionToImportanceDto.class)));
                    break;
                case DAY:
                    dayRepository.delete(conversionService.convertDtoToEntity(objectMapper.readValue(data, DayDto.class)));
                    break;
                case DAY_TO_TEST:
                    dayToTestRepository.delete(conversionService.convertDtoToEntity(objectMapper.readValue(data, DayToTestDto.class)));
                    break;
                case DREAM_ANSWER:
                    dreamAnswerRepository.delete(conversionService.convertDtoToEntity(objectMapper.readValue(data, DreamAnswerDto.class)));
                    break;
                case DREAM_QUESTION:
                    dreamQuestionRepository.delete(conversionService.convertDtoToEntity(objectMapper.readValue(data, DreamQuestionDto.class)));
                    break;
                case SAN_ANSWER:
                    sanAnswerRepository.delete(conversionService.convertDtoToEntity(objectMapper.readValue(data, SanAnswerDto.class)));
                    break;
                case SAN_QUESTION:
                    sanQuestionRepository.delete(conversionService.convertDtoToEntity(objectMapper.readValue(data, SanQuestionDto.class)));
                    break;
                case HEART_RATE:
                    heartRateRepository.delete(conversionService.convertDtoToEntity(objectMapper.readValue(data, HeartRateDto.class)));
                    break;
                case REST:
                    restRepository.delete(conversionService.convertDtoToEntity(objectMapper.readValue(data, RestDto.class)));
                    break;
                case SEASON_PLAN:
                    seasonPlanRepository.delete(conversionService.convertDtoToEntity(objectMapper.readValue(data, SeasonPlanDto.class)));
                    break;
                case TRAINING:
                    trainingRepository.delete(conversionService.convertDtoToEntity(objectMapper.readValue(data, TrainingDto.class)));
                    break;
                case TRAINING_EXERICSE:
                    trainingExerciseRepository.delete(conversionService.convertDtoToEntity(objectMapper.readValue(data, TrainingExerciseDto.class)));
                    break;
                case TRAININGS_TO_AIMS:
                    trainingsToAimsRepository.delete(conversionService.convertDtoToEntity(objectMapper.readValue(data, TrainingsToAimsDto.class)));
                    break;
                case TRAININGS_TO_EQUIPMENTS:
                    trainingsToEquipmentsRepository.delete(conversionService.convertDtoToEntity(objectMapper.readValue(data, TrainingsToEquipmentsDto.class)));
                    break;
            }
            return new ResponseEntity(HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
