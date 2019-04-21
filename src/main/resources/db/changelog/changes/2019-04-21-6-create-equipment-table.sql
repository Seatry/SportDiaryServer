CREATE TABLE IF NOT EXISTS Equipment
(
    id     int GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
    name   text default (''),
    userId text,
    unique (name, userId)
);