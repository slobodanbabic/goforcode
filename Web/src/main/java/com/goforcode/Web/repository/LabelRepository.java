package com.goforcode.Web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.goforcode.Web.model.Label;

@Repository
public interface LabelRepository extends JpaRepository<Label, Long>{

}
