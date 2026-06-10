USE sqldb;


SELECT * FROM usertbl U
INNER JOIN buytbl B
   ON U.userID = B.userID;


SELECT * FROM usertbl U
INNER JOIN buytbl B
   ON U.userID = B.userID
WHERE U.userID = 'JYP';


SELECT 
    U.userID, 
    U.name, 
    B.prodName, 
    U.addr, 
    CONCAT(U.mobile1, U.mobile2) AS '연락처'
FROM usertbl U
LEFT OUTER JOIN buytbl B
             ON U.userID = B.userID
ORDER BY U.userID ASC;


USE sqldb;


SELECT * FROM usertbl
WHERE mobile1 IS NOT NULL; 


SELECT * FROM usertbl
WHERE mobile1 IS NULL;