package com.cvs.inference.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cvs.inference.representation.Inference;

public interface InferenceRepository extends JpaRepository<Inference, Long> {

}