CREATE TABLE booking
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime NOT NULL,
    updated_at     datetime NOT NULL,
    review_id      BIGINT NULL,
    booking_status ENUM('SCHEDULED','PENDING','ASSIGNING_DRIVER','APPROVED','CAR_ARRIVED','IN_RIDE','COMPLETED','CANCELLED') NULL,
    started_at     datetime NULL,
    end_at         datetime NULL,
    total_distance DOUBLE NULL,
    driver_id      BIGINT NULL,
    passenger_id   BIGINT NULL,
    CONSTRAINT pk_booking PRIMARY KEY (id)
);

CREATE TABLE booking_review
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime     NOT NULL,
    updated_at datetime     NOT NULL,
    content    VARCHAR(255) NOT NULL,
    rating DOUBLE NOT NULL,
    CONSTRAINT pk_booking_review PRIMARY KEY (id)
);

CREATE TABLE driver
(
    id             BIGINT AUTO_INCREMENT NOT NULL,
    created_at     datetime     NOT NULL,
    updated_at     datetime     NOT NULL,
    name           VARCHAR(255) NOT NULL,
    license_number VARCHAR(255) NOT NULL,
    CONSTRAINT pk_driver PRIMARY KEY (id)
);

CREATE TABLE driver_review
(
    driver_id             BIGINT       NOT NULL,
    driver_review_rating DOUBLE NOT NULL,
    driver_review_content VARCHAR(255) NOT NULL,
    CONSTRAINT pk_driver_review PRIMARY KEY (driver_id)
);

CREATE TABLE passenger
(
    id         BIGINT AUTO_INCREMENT NOT NULL,
    created_at datetime NOT NULL,
    updated_at datetime NOT NULL,
    name       VARCHAR(255) NULL,
    CONSTRAINT pk_passenger PRIMARY KEY (id)
);

CREATE TABLE passenger_review
(
    passenger_id             BIGINT       NOT NULL,
    passenger_review_content VARCHAR(255) NOT NULL,
    passenger_review_rating DOUBLE NOT NULL,
    CONSTRAINT pk_passenger_review PRIMARY KEY (passenger_id)
);

ALTER TABLE driver
    ADD CONSTRAINT uc_driver_licensenumber UNIQUE (license_number);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES driver (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_PASSENGER FOREIGN KEY (passenger_id) REFERENCES passenger (id);

ALTER TABLE booking
    ADD CONSTRAINT FK_BOOKING_ON_REVIEW FOREIGN KEY (review_id) REFERENCES booking_review (id);

ALTER TABLE driver_review
    ADD CONSTRAINT FK_DRIVER_REVIEW_ON_DRIVER FOREIGN KEY (driver_id) REFERENCES booking_review (id);

ALTER TABLE passenger_review
    ADD CONSTRAINT FK_PASSENGER_REVIEW_ON_PASSENGER FOREIGN KEY (passenger_id) REFERENCES booking_review (id);