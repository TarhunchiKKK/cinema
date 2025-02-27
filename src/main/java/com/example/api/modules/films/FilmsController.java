package com.example.api.modules.films;

import java.util.HashMap;
import java.util.List;

import com.example.api.modules.films.entities.Film;
import com.example.api.modules.films.services.FilmsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.api.modules.films.dtos.CreateFilmRequest;
import com.example.api.modules.films.dtos.SearchFilmsRequest;
import com.example.api.modules.films.dtos.UpdateFilmRequest;
import com.example.api.shared.utils.ErrorsCollector;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmsController {
    private final FilmsService filmsService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateFilmRequest request, BindingResult bindingResult) {
        ErrorsCollector errorsCollector = new ErrorsCollector(bindingResult);
        if (errorsCollector.hasErrors()) {
            return new ResponseEntity<HashMap<String, String>>(errorsCollector.getErrors(), HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<Film>(this.filmsService.create(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Film>> findAll(@RequestParam(value = "country", required = false) String country) {
        SearchFilmsRequest request = new SearchFilmsRequest(country);
        return new ResponseEntity<List<Film>>(this.filmsService.findAll(request), HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody @Valid UpdateFilmRequest request,
            BindingResult bindingResult) {
        ErrorsCollector errorsCollector = new ErrorsCollector(bindingResult);
        if (errorsCollector.hasErrors()) {
            return new ResponseEntity<HashMap<String, String>>(errorsCollector.getErrors(), HttpStatus.BAD_REQUEST);
        }

        this.filmsService.update(id, request);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        this.filmsService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
