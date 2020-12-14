
CREATE TABLE  IF NOT EXISTS SHORT_URL (
  seq INT AUTO_INCREMENT  PRIMARY KEY,
  short_url VARCHAR(100),
  origin_url VARCHAR(2000) NOT NULL
);

CREATE SEQUENCE IF NOT EXISTS url_seq
MINVALUE 100000000
MAXVALUE 999999999
START WITH  100000000
INCREMENT BY 1
CACHE 20;
