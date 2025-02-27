package com.example.api.modules.seanses;

import java.util.HashMap;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.api.modules.seanses.dtos.CreateSeansRequest;
import com.example.api.modules.seanses.dtos.UpdateSeansRequest;
import com.example.api.modules.seanses.entities.Seans;
import com.example.api.modules.seanses.services.SeansesService;
import com.example.api.shared.utils.ErrorsCollector;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/seanses")
@RequiredArgsConstructor
public class SeansesController {
    private final SeansesService seansesService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateSeansRequest request, BindingResult bindingResult) {
        ErrorsCollector errorsCollector = new ErrorsCollector(bindingResult);
        if (errorsCollector.hasErrors()) {
            return new ResponseEntity<HashMap<String, String>>(errorsCollector.getErrors(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Seans>(this.seansesService.create(request), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Valid UpdateSeansRequest request,
            BindingResult bindingResult) {
        ErrorsCollector errorsCollector = new ErrorsCollector(bindingResult);
        if (errorsCollector.hasErrors()) {
            return new ResponseEntity<HashMap<String, String>>(errorsCollector.getErrors(), HttpStatus.BAD_REQUEST);
        }

        this.seansesService.update(id, request);
        return new ResponseEntity<Void>(HttpStatus.ACCEPTED);
    }

    @GetMapping("/film/{id}")
    public ResponseEntity<List<Seans>> findAllByFilmId(@PathVariable("id") Long id) {
        return new ResponseEntity<List<Seans>>(this.seansesService.findAllByFilmId(id), HttpStatus.OK);
    }

    @GetMapping("/visitor/{id}")
    public ResponseEntity<List<Seans>> findAllByVisitorId(@PathVariable("id") Long id) {
        return new ResponseEntity<List<Seans>>(this.seansesService.findAllByVisitorId(id), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<List<Seans>> findAllByEmployeeId(@PathVariable("id") Long id) {
        return new ResponseEntity<List<Seans>>(this.seansesService.findAllByEmployeeId(id), HttpStatus.OK);
    }
}
