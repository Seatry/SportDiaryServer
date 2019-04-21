CREATE TABLE IF NOT EXISTS DayToTest
(
    id     int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    day_id int,
    test_id int,
    CONSTRAINT DTT_DayId FOREIGN KEY (day_id)
        REFERENCES Day (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT DTT_TestId FOREIGN KEY (test_id)
        REFERENCES Test (id) ON DELETE CASCADE ON UPDATE CASCADE
);