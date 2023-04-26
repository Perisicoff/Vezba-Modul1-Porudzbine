DROP SCHEMA IF EXISTS porudzbine;
CREATE SCHEMA porudzbine DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE porudzbine;

CREATE TABLE proizvodi (
	id BIGINT AUTO_INCREMENT,
    sifra BIGINT NOT NULL,
	naziv VARCHAR(75) NOT NULL,
    cena BIGINT NOT NULL,
    besplatnaDostava BOOLEAN,
	PRIMARY KEY(id)
);

CREATE TABLE porudzbine (
	id BIGINT AUTO_INCREMENT,
    datumIVreme DATETIME NOT NULL,
	ulica VARCHAR(75) NOT NULL,
    broj BIGINT NOT NULL,
	proizvodId BIGINT NOT NULL,
	PRIMARY KEY(id),
    FOREIGN KEY(proizvodId) REFERENCES proizvodi(id),
    FOREIGN KEY(proizvodId) REFERENCES proizvodi(id) ON DELETE CASCADE
);




INSERT INTO proizvodi (id, sifra, naziv, cena, besplatnaDostava) VALUES ('1', '0001', 'Proizvod 1',  5000.00, false);
INSERT INTO proizvodi (id, sifra, naziv, cena, besplatnaDostava) VALUES ('2', '0002', 'Proizvod 2',  100000.00, false);
INSERT INTO proizvodi (id, sifra, naziv, cena, besplatnaDostava) VALUES ('3', '0003', 'Proizvod 3', 15000.00, true);

# porudžbine: datum i vreme, ulica, broj, proizvod
INSERT INTO porudzbine (datumIVreme, ulica,  broj, proizvodId) VALUES ('2021-09-01 10:00', 'Bul. Oslobođenja', 10, 1);
INSERT INTO porudzbine (datumIVreme, ulica,  broj, proizvodId) VALUES ('2021-09-01 14:00', 'Bul. Mihajla Pupina', 10, 1);
INSERT INTO porudzbine (datumIVreme, ulica,  broj, proizvodId) VALUES ('2021-09-01 20:00', 'Bul. Oslobođenja', 20, 2);
INSERT INTO porudzbine (datumIVreme, ulica,  broj, proizvodId) VALUES ('2021-09-02 10:30', 'Bul. Cara Lazara', 10, 1);
INSERT INTO porudzbine (datumIVreme, ulica,  broj, proizvodId) VALUES ('2021-09-02 14:30', 'Bul. Oslobođenja', 30, 3);
INSERT INTO porudzbine (datumIVreme, ulica,  broj, proizvodId) VALUES ('2021-09-03 10:00', 'Bul. Mihajla Pupina', 20, 2);
INSERT INTO porudzbine (datumIVreme, ulica,  broj, proizvodId) VALUES ('2021-09-03 14:00', 'Bul. Mihajla Pupina', 30, 3);
INSERT INTO porudzbine (datumIVreme, ulica,  broj, proizvodId) VALUES ('2021-09-03 20:00', 'Bul. Cara Lazara', 20, 1);