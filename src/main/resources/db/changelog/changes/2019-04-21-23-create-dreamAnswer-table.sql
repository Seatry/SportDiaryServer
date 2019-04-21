CREATE TABLE IF NOT EXISTS DreamAnswer
(
    id     int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    answer int,
    day_id int,
    question_id int,
    CONSTRAINT DA_DayId FOREIGN KEY (day_id)
        REFERENCES Day (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT DA_QuestionId FOREIGN KEY (question_id)
        REFERENCES DreamQuestion (id) ON DELETE CASCADE ON UPDATE CASCADE
);