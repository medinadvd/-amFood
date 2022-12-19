package com.Namfood.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Namfood.Entity.PreferenceRest;

@Repository
public interface PreferenceRestRepository extends JpaRepository<PreferenceRest, Integer> {
}