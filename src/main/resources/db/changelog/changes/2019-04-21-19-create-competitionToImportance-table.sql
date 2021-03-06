CREATE TABLE IF NOT EXISTS CompetitionToImportance
(
    id     int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    competition_id   int,
    importance_id int,
    CONSTRAINT CTI_CompetitionId FOREIGN KEY (competition_id)
        REFERENCES Competition (id) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT CTI_ImportanceId FOREIGN KEY (importance_id)
        REFERENCES Importance (id) ON DELETE SET NULL ON UPDATE CASCADE
);