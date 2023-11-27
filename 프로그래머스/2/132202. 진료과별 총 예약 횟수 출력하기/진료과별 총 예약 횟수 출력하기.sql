SELECT MCDP_CD AS 진료과코드, COUNT(MCDP_CD) AS 5월예약건수
FROM APPOINTMENT
WHERE DATE_FORMAT(APNT_YMD, '%Y-%m-%d') BETWEEN '2022-05-01' AND '2022-05-31'  
GROUP BY MCDP_CD
ORDER BY 5월예약건수, 진료과코드;