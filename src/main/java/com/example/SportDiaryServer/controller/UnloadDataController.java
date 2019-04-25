package com.example.SportDiaryServer.controller;

import com.example.SportDiaryServer.dto.EditDto;
import com.example.SportDiaryServer.dto.UnloadDto;
import com.example.SportDiaryServer.entity.editEntity.Edit;
import com.example.SportDiaryServer.repository.*;
import com.example.SportDiaryServer.repository.editRepository.*;
import com.example.SportDiaryServer.service.conversion.EntityDtoConversionService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class UnloadDataController {
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
    private final SeasonPlanRepository seasonPlanRepository;
    private final DreamQuestionRepository dreamQuestionRepository;
    private final SanQuestionRepository sanQuestionRepository;
    private final EntityDtoConversionService conversionService;
    private final CompetitionToImportanceRepository competitionToImportanceRepository;
    private final DayRepository dayRepository;
    private final DayToTestRepository dayToTestRepository;
    private final DreamAnswerRepository dreamAnswerRepository;
    private final HeartRateRepository heartRateRepository;
    private final RestRepository restRepository;
    private final SanAnswerRepository sanAnswerRepository;
    private final TrainingExerciseRepository trainingExerciseRepository;
    private final TrainingRepository trainingRepository;
    private final TrainingsToAimsRepository trainingsToAimsRepository;
    private final TrainingsToEquipmentsRepository trainingsToEquipmentsRepository;
    private final VersionRepository versionRepository;

    @Autowired
    public UnloadDataController(TimeRepository timeRepository, AimRepository aimRepository, BlockRepository blockRepository,
                                BorgRepository borgRepository, CampRepository campRepository, CompetitionRepository competitionRepository,
                                EquipmentRepository equipmentRepository, ExerciseRepository exerciseRepository, ImportanceRepository importanceRepository,
                                RestPlaceRepository restPlaceRepository, StageRepository stageRepository, StyleRepository styleRepository,
                                TempoRepository tempoRepository, TestRepository testRepository, TrainingPlaceRepository trainingPlaceRepository,
                                TypeRepository typeRepository, ZoneRepository zoneRepository, SeasonPlanRepository seasonPlanRepository,
                                DreamQuestionRepository dreamQuestionRepository, SanQuestionRepository sanQuestionRepository,
                                EntityDtoConversionService conversionService, CompetitionToImportanceRepository competitionToImportanceRepository,
                                DayRepository dayRepository, DayToTestRepository dayToTestRepository, DreamAnswerRepository dreamAnswerRepository,
                                HeartRateRepository heartRateRepository, RestRepository restRepository, SanAnswerRepository sanAnswerRepository,
                                TrainingExerciseRepository trainingExerciseRepository, TrainingRepository trainingRepository,
                                TrainingsToAimsRepository trainingsToAimsRepository, TrainingsToEquipmentsRepository trainingsToEquipmentsRepository, VersionRepository versionRepository) {
        this.timeRepository = timeRepository;
        this.aimRepository = aimRepository;
        this.blockRepository = blockRepository;
        this.borgRepository = borgRepository;
        this.campRepository = campRepository;
        this.competitionRepository = competitionRepository;
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
        this.seasonPlanRepository = seasonPlanRepository;
        this.dreamQuestionRepository = dreamQuestionRepository;
        this.sanQuestionRepository = sanQuestionRepository;
        this.conversionService = conversionService;
        this.competitionToImportanceRepository = competitionToImportanceRepository;
        this.dayRepository = dayRepository;
        this.dayToTestRepository = dayToTestRepository;
        this.dreamAnswerRepository = dreamAnswerRepository;
        this.heartRateRepository = heartRateRepository;
        this.restRepository = restRepository;
        this.sanAnswerRepository = sanAnswerRepository;
        this.trainingExerciseRepository = trainingExerciseRepository;
        this.trainingRepository = trainingRepository;
        this.trainingsToAimsRepository = trainingsToAimsRepository;
        this.trainingsToEquipmentsRepository = trainingsToEquipmentsRepository;
        this.versionRepository = versionRepository;
    }

    @SuppressWarnings("Duplicates")
    @RequestMapping(value = "/unload", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<UnloadDto> onUnload(@RequestParam("userId") String userId){
        var seasonPlans = seasonPlanRepository.findAllByUserId(userId)
                .stream()
                .map(conversionService::convertEntityToDto)
                .collect(Collectors.toList());
        
        for (var seasonPlan : seasonPlans) {
            var days = dayRepository.findAllBySeasonPlanId(seasonPlan.getId())
                    .stream()
                    .map(conversionService::convertEntityToDto)
                    .collect(Collectors.toList());
            for (var day : days) {
                var trainings = trainingRepository.findAllByDayId(day.getId())
                        .stream()
                        .map(conversionService::convertEntityToDto)
                        .collect(Collectors.toList());
                for (var training : trainings) {
                    var trainingExercises = trainingExerciseRepository.findAllByTrainingId(training.getId())
                            .stream()
                            .map(conversionService::convertEntityToDto)
                            .collect(Collectors.toList());
                    for (var trainingExercise : trainingExercises) {
                        var heartRates = heartRateRepository.findAllByExerciseId(trainingExercise.getId())
                                .stream()
                                .map(conversionService::convertEntityToDto)
                                .collect(Collectors.toList());
                        trainingExercise.setHeartRates(heartRates);
                    }
                    var trainingsToAims = trainingsToAimsRepository.findAllByTrainingId(training.getId())
                            .stream()
                            .map(conversionService::convertEntityToDto)
                            .collect(Collectors.toList());
                    var trainingToEquipments = trainingsToEquipmentsRepository.findAllByTrainingId(training.getId())
                            .stream()
                            .map(conversionService::convertEntityToDto)
                            .collect(Collectors.toList());
                    training.setTrainingsToAims(trainingsToAims);
                    training.setTrainingsToEquipments(trainingToEquipments);
                    training.setTrainingExercises(trainingExercises);
                }
                if (day.getCompetitionToImportanceId() != null) {
                    var cti = competitionToImportanceRepository.findById(day.getCompetitionToImportanceId()).get();
                    var ctiDto = conversionService.convertEntityToDto(cti);
                    day.setCompetitionToImportance(ctiDto);
                }
                var dayToTests = dayToTestRepository.findAllByDayId(day.getId())
                        .stream()
                        .map(conversionService::convertEntityToDto)
                        .collect(Collectors.toList());
                var rests = restRepository.findAllByDayId(day.getId())
                        .stream()
                        .map(conversionService::convertEntityToDto)
                        .collect(Collectors.toList());
                var dreamAnswers = dreamAnswerRepository.findAllByDayId(day.getId())
                        .stream()
                        .map(conversionService::convertEntityToDto)
                        .collect(Collectors.toList());
                var sanAnswers = sanAnswerRepository.findAllByDayId(day.getId())
                        .stream()
                        .map(conversionService::convertEntityToDto)
                        .collect(Collectors.toList());

                day.setDreamAnswers(dreamAnswers);
                day.setSanAnswers(sanAnswers);
                day.setRests(rests);
                day.setDayToTests(dayToTests);
                day.setTrainings(trainings);
            }
            seasonPlan.setDays(days);
        }

        var dreamQuestions = dreamQuestionRepository.findAll()
                .stream()
                .map(conversionService::convertEntityToDto)
                .collect(Collectors.toList());
        var sanQuestions = sanQuestionRepository.findAll()
                .stream()
                .map(conversionService::convertEntityToDto)
                .collect(Collectors.toList());
        var times = getDto(timeRepository.findAllByUserId(userId));
        var aims = getDto(aimRepository.findAllByUserId(userId));
        var blocks = getDto(blockRepository.findAllByUserId(userId));
        var borgs = getDto(borgRepository.findAllByUserId(userId));
        var camps = getDto(campRepository.findAllByUserId(userId));
        var competitions = getDto(competitionRepository.findAllByUserId(userId));
        var equipments = getDto(equipmentRepository.findAllByUserId(userId));
        var exercises = getDto(exerciseRepository.findAllByUserId(userId));
        var importances = getDto(importanceRepository.findAllByUserId(userId));
        var restPlaces = getDto(restPlaceRepository.findAllByUserId(userId));
        var stages = getDto(stageRepository.findAllByUserId(userId));
        var styles = getDto(styleRepository.findAllByUserId(userId));
        var tempos = getDto(tempoRepository.findAllByUserId(userId));
        var tests = getDto(testRepository.findAllByUserId(userId));
        var trainingPlaces = getDto(trainingPlaceRepository.findAllByUserId(userId));
        var types = getDto(typeRepository.findAllByUserId(userId));
        var zones = getDto(zoneRepository.findAllByUserId(userId));

        var unloadDto = new UnloadDto();
        unloadDto.setSeasonPlanDtos(seasonPlans)
                .setDreamQuestionDtos(dreamQuestions)
                .setSanQuestionDtos(sanQuestions)
                .setTimes(times)
                .setAims(aims)
                .setBlock(blocks)
                .setBorg(borgs)
                .setCamps(camps)
                .setCompetitions(competitions)
                .setEquipments(equipments)
                .setExercises(exercises)
                .setImportances(importances)
                .setRestPlaces(restPlaces)
                .setStages(stages)
                .setStyles(styles)
                .setTempos(tempos)
                .setTests(tests)
                .setTrainingPlaces(trainingPlaces)
                .setTypes(types)
                .setZones(zones);
        var version = versionRepository.findByUserId(userId);
        if (version != null) {
            unloadDto.setVersionDto(conversionService.convertEntityToDto(version));
        }

        return new ResponseEntity<>(unloadDto, HttpStatus.OK);
    }

    private <T extends Edit> List<EditDto> getDto(List<T> edits) {
        return edits.stream()
                .map(conversionService::convertEntityToDto)
                .collect(Collectors.toList());
    }
}
