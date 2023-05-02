use Board;

-- 전체 : type=all
SELECT 
    *
FROM
    Board
WHERE
	title LIKE '%%' 
    OR 
    body LIKE '%%'
	OR 
    writer LIKE '%%';
    
-- 제목 : type=title
SELECT 
    *
FROM
    Board
WHERE
    title LIKE '%%';
    
SELECT 
    *
FROM
    Board
WHERE
    title LIKE '%샘플%'