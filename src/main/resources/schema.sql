-- Create the database
CREATE DATABASE IF NOT EXISTS `patientdb` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- Use the database
USE `patientdb`;

-- Create the patient table
CREATE TABLE IF NOT EXISTS `patient` (
                                         `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         `name` VARCHAR(255) NOT NULL,
    `age` INT NOT NULL,
    `gender` VARCHAR(10) NOT NULL,
    `phoneNumber` VARCHAR(20),
    `address` VARCHAR(255)
    );

-- Create the visit table
CREATE TABLE IF NOT EXISTS `visit` (
                                       `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                       `visitDateTime` DATETIME NOT NULL,
                                       `patient_id` BIGINT,
                                       FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`)
    );

-- Create the disease table
CREATE TABLE IF NOT EXISTS `disease` (
                                         `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                         `name` VARCHAR(255) NOT NULL
    );

-- Create the doctor table
CREATE TABLE IF NOT EXISTS `doctor` (
                                        `id` BIGINT AUTO_INCREMENT PRIMARY KEY,
                                        `name` VARCHAR(255) NOT NULL
    );

-- Create the join tables for many-to-many relationships
-- Example: patient_disease
CREATE TABLE IF NOT EXISTS `patient_disease` (
                                                 `patient_id` BIGINT,
                                                 `disease_id` BIGINT,
                                                 PRIMARY KEY (`patient_id`, `disease_id`),
    FOREIGN KEY (`patient_id`) REFERENCES `patient` (`id`),
    FOREIGN KEY (`disease_id`) REFERENCES `disease` (`id`)
    );

-- Example: visit_doctor
CREATE TABLE IF NOT EXISTS `visit_doctor` (
                                              `visit_id` BIGINT,
                                              `doctor_id` BIGINT,
                                              PRIMARY KEY (`visit_id`, `doctor_id`),
    FOREIGN KEY (`visit_id`) REFERENCES `visit` (`id`),
    FOREIGN KEY (`doctor_id`) REFERENCES `doctor` (`id`)
    );

-- Insert sample data into the patient table
INSERT INTO `patient` (`name`, `age`, `gender`, `phoneNumber`, `address`) VALUES
('John Doe', 30, 'Male', '1234567890', '123 Main St'),
('Jane Doe', 25, 'Female', '9876543210', '456 Oak St');

-- Insert sample data into the disease table
INSERT INTO `disease` (`name`) VALUES
('Fever'),
('Cough'),
('Headache');

-- Insert sample data into the doctor table
INSERT INTO `doctor` (`name`) VALUES
('Dr. Smith'),
('Dr. Johnson');

-- Insert sample data into the visit table
INSERT INTO `visit` (`visitDateTime`, `patient_id`) VALUES
('2024-02-05 10:00:00', 1),
('2024-02-06 14:30:00', 2);

-- Insert sample data into the patient_disease table (many-to-many relationship)
INSERT INTO `patient_disease` (`patient_id`, `disease_id`) VALUES
(1, 1),
(1, 2),
(2, 3);

-- Insert sample data into the visit_doctor table (many-to-many relationship)
INSERT INTO `visit_doctor` (`visit_id`, `doctor_id`) VALUES
(1, 1),
(1, 2),
(2, 2);
