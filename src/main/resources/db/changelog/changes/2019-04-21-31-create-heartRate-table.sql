CREATE TABLE IF NOT EXISTS HeartRate
(
    id     int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,

    repeat int,
    series int,
    hr int default(0),
    time varchar(10),
    exercise_id int,
    CONSTRAINT HR_ExerciseId FOREIGN KEY (exercise_id)
        REFERENCES TrainingExercise (id) ON DELETE CASCADE ON UPDATE CASCADE
);