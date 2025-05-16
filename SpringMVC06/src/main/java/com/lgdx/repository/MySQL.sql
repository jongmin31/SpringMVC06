DROP TABLE BOARD;

INSERT INTO BOARD(TITLE, CONTENTS, WRITER)
VALUES('진짜 중요 공지', '보노보노 vs 욘두 가슴이 웅장해진다!', '이문형');

INSERT INTO BOARD(TITLE, CONTENTS, WRITER)
VALUES('돈 쉽게 버는 법 알려줌', '주식 안하면 됨 ㅋㅋ', '혜영개백숙');

INSERT INTO BOARD(TITLE, CONTENTS, WRITER)
VALUES('제목', '아..말린다 진짜', '건조 오징어');

COMMIT;

SELECT * FROM Member;