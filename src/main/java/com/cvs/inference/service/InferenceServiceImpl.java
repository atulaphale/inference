package com.cvs.inference.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.cvs.inference.repository.InferenceRepository;
import com.cvs.inference.representation.Inference;
import com.cvs.inference.service.InferenceService;

@Service
public class InferenceServiceImpl implements InferenceService {

    @Autowired
    private InferenceRepository inferenceRepository;

    public void setInferenceRepository(InferenceRepository inferenceRepository) {
        this.inferenceRepository = inferenceRepository;
    }

    public List<Inference> retrieveInferences(){
        List<Inference> inferences = inferenceRepository.findAll();
        return inferences;
    }

    public Inference getInference(Long id){
        Optional<Inference> optInference = inferenceRepository.findById(id);
        return optInference.get();
    }

    public void saveInference(Inference infer){
        inferenceRepository.save(infer);
    }

    public void deleteInference(Long id){
        inferenceRepository.deleteById(id);
    }

}