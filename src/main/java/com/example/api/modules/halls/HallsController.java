package com.example.api.modules.halls;

import java.util.HashMap;
import java.util.List;
import com.example.api.modules.halls.entities.Hall;
import com.example.api.modules.halls.services.HallsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.api.modules.halls.dtos.CreateHallRequest;
import com.example.api.modules.halls.dtos.SearchHallsRequest;
import com.example.api.modules.halls.dtos.UpdateHallRequest;
import com.example.api.shared.utils.ErrorsCollector;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/halls")
@RequiredArgsConstructor
public class HallsController {
    private final HallsService hallsService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateHallRequest request, BindingResult bindingResult) {
        ErrorsCollector errorsCollector = new ErrorsCollector(bindingResult);
        if (errorsCollector.hasErrors()) {
            return new ResponseEntity<HashMap<String, String>>(errorsCollector.getErrors(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Hall>(this.hallsService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Hall>> findAll(@RequestParam(value = "type", required = false) String type) {
        SearchHallsRequest request = new SearchHallsRequest(type);
        return new ResponseEntity<List<Hall>>(this.hallsService.findAll(request), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Valid UpdateHallRequest request,
            BindingResult bindingResult) {
        ErrorsCollector errorsCollector = new ErrorsCollector(bindingResult);
        if (errorsCollector.hasErrors()) {
            return new ResponseEntity<HashMap<String, String>>(errorsCollector.getErrors(), HttpStatus.BAD_REQUEST);
        }

        this.hallsService.update(id, request);

        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.hallsService.delete(id);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
