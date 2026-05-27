# max만을 사용하면 ID가 다르기 때문에 사용 불가
# ID를 어떻게 가져올 것이냐가 문제.
# 서브쿼리를 통해 MAX LENGTH인 애를 가져오고, ID는 본 쿼리에서 LENGTH가 동일한 애를 가져오면 될 듯 함

SELECT A.ID, B.FISH_NAME, A.LENGTH
FROM FISH_INFO A
    INNER JOIN FISH_NAME_INFO B
    ON A.FISH_TYPE = B.FISH_TYPE
WHERE (A.FISH_TYPE, A.LENGTH) IN (
        SELECT FISH_TYPE, MAX(LENGTH)
        FROM FISH_INFO
        GROUP BY FISH_TYPE
    )
ORDER BY ID ASC