package org.vji.surveyapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.vji.surveyapi.entities.AnswerSheet;
import org.vji.surveyapi.entities.Reward;

import java.util.List;

@Repository
public interface IRewardRepository extends JpaRepository<Reward, Long> {

    @Query(value = "select * from rewards where survey_id =:surveyId", nativeQuery = true)
    List<Reward> getAllFrom(Long surveyId);
}
