CREATE TABLE IF NOT EXISTS poi (
                                   poi_id SERIAL PRIMARY KEY, -- SERIAL veri türü, otomatik artan birincil anahtar oluşturur.
                                   latitude DOUBLE PRECISION NOT NULL, -- DOUBLE PRECISION, kesinliği yüksek bir kayan nokta sayısıdır.
                                   longitude DOUBLE PRECISION NOT NULL,
                                   description VARCHAR(255) -- VARCHAR veri türü, belirtilen uzunluktaki bir karakter dizisini depolar.
              --                      type VARCHAR(100)
);

CREATE TABLE IF NOT EXISTS users(
                                    id SERIAL PRIMARY KEY, -- SERIAL veri türü, otomatik artan birincil anahtar oluşturur.
                                    name VARCHAR(50) NOT NULL,
                                    surname VARCHAR(50) NOT NULL,
                                    email VARCHAR(255) NOT NULL UNIQUE -- Ensures that email addresses are unique.
);

CREATE TABLE  IF NOT EXISTS airquality (
                                    id SERIAL PRIMARY KEY, -- SERIAL veri türü, otomatik artan birincil anahtar oluşturur.
                                    airquality integer NOT NULL,
                                    timestamp timestamp NOT NULL,
                                    poi_id integer not null,
                                    CONSTRAINT fk_poi foreign key (poi_id) references poi(poi_id)
);


