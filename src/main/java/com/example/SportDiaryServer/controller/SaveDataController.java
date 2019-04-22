package com.example.SportDiaryServer.controller;

import com.example.SportDiaryServer.dto.*;
import com.example.SportDiaryServer.repository.*;
import com.example.SportDiaryServer.repository.editRepository.*;
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
    private final TimeRepository timeRepository;
    private final AimRepository aimRepository;
    private final BlockRepository blockRepository;
    private final BorgRepository borgRepository;
    private final CampRepository campRepository;
    private final CompetitionRepository competitionRepository;
    private final EquipmentRepository equipmentRepository;
    private final ExerciseRepository exerciseRepository;
    private final ImportanceRepository importanceRepository;
    private final RestPlaceRepository restPlaceRepository;
    private final StageRepository stageRepository;
    private final StyleRepository styleRepository;
    private final TempoRepository tempoRepository;
    private final TestRepository testRepository;
    private final TrainingPlaceRepository trainingPlaceRepository;
    private final TypeRepository typeRepository;
    private final ZoneRepository zoneRepository;
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
    public SaveDataController(CompetitionRepository competitionRepository, EntityDtoConversionService conversionService, TimeRepository timeRepository,
                              AimRepository aimRepository, BlockRepository blockRepository, BorgRepository borgRepository,
                              CampRepository campRepository, EquipmentRepository equipmentRepository, ExerciseRepository exerciseRepository,
                              ImportanceRepository importanceRepository, RestPlaceRepository restPlaceRepository,
                              StageRepository stageRepository, StyleRepository styleRepository, TempoRepository tempoRepository,
                              TestRepository testRepository, TrainingPlaceRepository trainingPlaceRepository, TypeRepository typeRepository,
                              ZoneRepository zoneRepository, CompetitionToImportanceRepository competitionToImportanceRepository, DayRepository dayRepository,
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
            switch (table.toLowerCase()) {
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
                    var seasonPlanDto = objectMapper.readValue(data, SeasonPlanDto.class);
                    seasonPlanRepository.save(conversionService.convertDtoToEntity(seasonPlanDto));
                    for (var dayDto : seasonPlanDto.getDays()) {
                        dayRepository.save(conversionService.convertDtoToEntity(dayDto));
                    }
                    break;
                case TRAINING:
                    trainingRepository.save(conversionService.convertDtoToEntity(objectMapper.readValue(data, TrainingDto.class)));
                    break;
                case TRAINING_EXERCISE:
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
                                   @RequestParam("id") Long id) {
        switch (table) {
            case TIME:
                timeRepository.deleteById(id);
                break;
            case AIM:
                aimRepository.deleteById(id);
                break;
            case BLOCK:
                blockRepository.deleteById(id);
                break;
            case BORG:
                borgRepository.deleteById(id);
                break;
            case CAMP:
                campRepository.deleteById(id);
                break;
            case COMPETITION:
                competitionRepository.deleteById(id);
                break;
            case EQUIPMENT:
                equipmentRepository.deleteById(id);
                break;
            case EXERCISE:
                exerciseRepository.deleteById(id);
                break;
            case IMPORTANCE:
                importanceRepository.deleteById(id);
                break;
            case REST_PLACE:
                restPlaceRepository.deleteById(id);
                break;
            case STAGE:
                stageRepository.deleteById(id);
                break;
            case STYLE:
                styleRepository.deleteById(id);
                break;
            case TEMPO:
                tempoRepository.deleteById(id);
                break;
            case TEST:
                testRepository.deleteById(id);
                break;
            case TRAINING_PLACE:
                trainingPlaceRepository.deleteById(id);
                break;
            case TYPE:
                typeRepository.deleteById(id);
                break;
            case ZONE:
                zoneRepository.deleteById(id);
                break;
            case COMPETITION_TO_IMPORTANCE:
                competitionToImportanceRepository.deleteById(id);
                break;
            case DAY:
                dayRepository.deleteById(id);
                break;
            case DAY_TO_TEST:
                dayToTestRepository.deleteById(id);
                break;
            case DREAM_ANSWER:
                dreamAnswerRepository.deleteById(id);
                break;
            case DREAM_QUESTION:
                dreamQuestionRepository.deleteById(id);
                break;
            case SAN_ANSWER:
                sanAnswerRepository.deleteById(id);
                break;
            case SAN_QUESTION:
                sanQuestionRepository.deleteById(id);
                break;
            case HEART_RATE:
                heartRateRepository.deleteById(id);
                break;
            case REST:
                restRepository.deleteById(id);
                break;
            case SEASON_PLAN:
                seasonPlanRepository.deleteById(id);
                break;
            case TRAINING:
                trainingRepository.deleteById(id);
                break;
            case TRAINING_EXERCISE:
                trainingExerciseRepository.deleteById(id);
                break;
            case TRAININGS_TO_AIMS:
                trainingsToAimsRepository.deleteById(id);
                break;
            case TRAININGS_TO_EQUIPMENTS:
                trainingsToEquipmentsRepository.deleteById(id);
                break;
        }
        return new ResponseEntity(HttpStatus.OK);
    }
}
