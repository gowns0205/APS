SELECT  HOUR(DATETIME) AS HOUR, COUNT(DATETIME) AS COUNT
FROM ANIMAL_OUTS
WHERE HOUR(DATETIME) BETWEEN 9 AND 20
GROUP BY HOUR
ORDER BY HOUR;