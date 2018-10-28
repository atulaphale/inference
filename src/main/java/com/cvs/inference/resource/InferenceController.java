package com.cvs.inference.resource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.springframework.http.MediaType;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import com.cvs.inference.representation.Inference;
import com.cvs.inference.service.InferenceService;
import java.util.List;


@RestController
@Api(value="inferenceOptions", description="Operations pertaining to inference persistence application")
@RequestMapping(path="/api/v1")
public class InferenceController {

    @Autowired
    private InferenceService inferenceService;

    @ApiOperation(value = "Retrieved all inferences from database",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully retrieved the inferences"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/inference", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Inference> getInferences(){
        List<Inference> listInferences = inferenceService.retrieveInferences();
        System.out.println("Inference fetched successfully");
        return listInferences;
    }

    @ApiOperation(value = "Save the inference in database",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully saved the inference"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/inference/{inferenceId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Inference getInference(@PathVariable(name="inferenceId") Long id){
        Inference infer = inferenceService.getInference(id);
        System.out.println("Inference fetched successfully");
        return infer;
    }

    @ApiOperation(value = "Save the inference in database",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully saved the inference"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/inference", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public void createInference(Inference infer){
        inferenceService.saveInference(infer);
        System.out.println("Inference saved successfully");
    }

    @ApiOperation(value = "Delete the inference from database",response = Iterable.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted the inference"),
            @ApiResponse(code = 401, message = "You are not authorized to view the resource"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    }
    )
    @RequestMapping(value = "/inference/{inferenceId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void deleteInference(@PathVariable(name="inferenceId") Long id){
        inferenceService.deleteInference(id);
        System.out.println("Inference deleted successfully");
    }

}
