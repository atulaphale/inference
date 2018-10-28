package com.cvs.inference.service;

import java.util.List;
import com.cvs.inference.representation.Inference;

public interface InferenceService{

    public List<Inference> retrieveInferences();

    public Inference getInference(Long id);

    public void saveInference(Inference infer);

    public void deleteInference(Long id);
}