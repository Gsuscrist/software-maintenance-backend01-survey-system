package org.vji.surveyapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.vji.surveyapi.entities.Response;

@Repository
public interface IResponseRepository extends JpaRepository<Response, Long> {
}
