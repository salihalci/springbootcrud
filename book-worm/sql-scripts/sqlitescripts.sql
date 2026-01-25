-- SQLITE SCRIPT TO CREATE AND POPULATE BOOK TABLE

DROP TABLE IF EXISTS book;

-- Base table creation with startdate, enddate, comment
CREATE TABLE book (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    title TEXT,
    author TEXT,
    picture_url TEXT,
    startdate DATE,
    enddate DATE,
    comment TEXT
);

-- Sample data insertion
INSERT INTO book (id, title, author, picture_url, startdate, enddate, comment) VALUES
(1, 'Sefiller', 'Victor Hugo', 'sefiller.jpg', '2023-01-01', '2023-01-31', 'Klasik Fransız edebiyatının başyapıtı.'),
(2, 'Suç ve Ceza', 'Fyodor Dostoyevski', 'suc_ve_ceza.jpg', '2023-02-01', '2023-02-28', 'Rus edebiyatının derin bir psikolojik incelemesi.'),
(3, '1984', 'George Orwell', '1984.jpg', '2023-03-01', '2023-03-31', 'Distopik bir gelecek anlatısı.'),
(4, 'Kürk Mantolu Madonna', 'Sabahattin Ali', 'kurk_mantolu_madonna.jpg', '2023-04-01', '2023-04-30', 'Türk edebiyatının unutulmaz aşk romanı.'),
(5, 'Simyacı', 'Paulo Coelho', 'simyaci.jpg', '2023-05-01', '2023-05-31', 'Hayallerin peşinden gitme temalı ünlü roman.');
