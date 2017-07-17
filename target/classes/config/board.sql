
SELECT * FROM Board;
DROP TABLE Board;
DROP SEQUENCE board_seq;

-- CREATE SEQUENCE seq
CREATE SEQUENCE board_seq
START WITH 1
INCREMENT BY 1
NOCACHE NOCYCLE;

-- CREATE Board TABLE
CREATE TABLE Board (
	seq DECIMAL PRIMARY KEY,
	id VARCHAR2(30) NOT NULL,
	title VARCHAR2(100) NOT NULL,
	content VARCHAR2(2000) NOT NULL,
	regdate DATE DEFAULT SYSDATE NOT NULL,
	hit_cnt NUMBER NOT NULL
);

INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung1','Hi','Hello my friends', sysdate,3);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung1','Second','MY SECOND ARTICLE',sysdate,5);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung1','Third','MY THIRD ARTICLE',sysdate,7);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung1','Forth','MY FOUTH ARTICLE',sysdate,4);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung1','Fifth','MY FIFTH ARTICLE',sysdate,2);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'admin','Hi2','Hello my friends2',sysdate,3);

INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung2','H2','Hello my friends', sysdate,3);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung2','Second2','MY SECOND ARTICLE',sysdate,5);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung2','Third2','MY THIRD ARTICLE',sysdate,7);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung2','Forth2','MY FOUTH ARTICLE',sysdate,4);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung2','Fifth2','MY FIFTH ARTICLE',sysdate,2);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'admi2','Hi22','Hello my friends2',sysdate,3);

INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung3','Hi3','Hello my friends', sysdate,3);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung3','Second3','MY SECOND ARTICLE',sysdate,5);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung3','Third3','MY THIRD ARTICLE',sysdate,7);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung3','Forth3','MY FOUTH ARTICLE',sysdate,4);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung3','Fifth3','MY FIFTH ARTICLE',sysdate,2);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'admin3','Hi3','Hello my friends2',sysdate,3);

INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung4','Hi4','Hello my friends', sysdate,3);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung4','Second4','MY SECOND ARTICLE',sysdate,5);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung4','Third4','MY THIRD ARTICLE',sysdate,7);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung4','Forth4','MY FOUTH ARTICLE',sysdate,4);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung4','Fifth4','MY FIFTH ARTICLE',sysdate,2);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'admin4','Hi4','Hello my friends2',sysdate,3);

INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung5','Hi','Hello my friends', sysdate,3);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung5','Second','MY SECOND ARTICLE',sysdate,5);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung5','Third','MY THIRD ARTICLE',sysdate,7);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung5','Forth','MY FOUTH ARTICLE',sysdate,4);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'babung5','Fifth','MY FIFTH ARTICLE',sysdate,2);
INSERT INTO Board(seq, id, title, content, regdate, hit_cnt) VALUES (seq.nextval, 'admin5','Hi2','Hello my friends2',sysdate,3);

-- QUERY FOR Pagination
SELECT t2.*
FROM (SELECT ROWNUM art_seq, t.* 
FROM (SELECT * FROM Board ORDER BY seq DESC) t) t2
WHERE t2.art_seq BETWEEN 1 AND 5;

-- IN MAPPER
SELECT t2.* FROM (SELECT ROWNUM art_seq, t.* FROM (SELECT * FROM Board ORDER BY seq DESC) t) t2 WHERE t2.art_seq BETWEEN 1 AND 5
SELECT t2.* FROM (SELECT ROWNUM art_seq, t.* FROM (SELECT * FROM Board ORDER BY seq DESC) t) t2 WHERE t2.art_seq BETWEEN ${startRow} AND ${endRow}
