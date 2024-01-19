package org.vji.surveyapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vji.surveyapi.entities.Reward;

@Repository
public interface IRewardRepository extends JpaRepository<Reward, Long> {
}
