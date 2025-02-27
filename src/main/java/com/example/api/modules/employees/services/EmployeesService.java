package com.example.api.modules.employees.services;

import com.example.api.modules.employees.entities.Employee;
import com.example.api.modules.employees.repositories.EmployeesRepository;
import com.example.api.modules.employees.utils.SearchEmployeeByProfileQueryBuilder;
import com.example.api.modules.seanses.entities.Seans;
import com.example.api.modules.seanses.services.SeansesService;
import com.example.api.shared.interfaces.IQueryBuilder;
import org.springframework.stereotype.Service;
import com.example.api.modules.auth.entties.Profile;
import com.example.api.modules.auth.services.ProfilesService;
import com.example.api.modules.employees.dtos.CreateEmployeeRequest;
import com.example.api.modules.employees.dtos.ToggleEmployeeSeansRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeesService {
    private final EmployeesRepository employeesRepository;

    private final SeansesService seansesService;

    private final ProfilesService profilesService;

    public Employee create(CreateEmployeeRequest request) {
        return this.employeesRepository.save(
                new Employee(request.getFio(), request.getPost(), request.getExperience(), request.getProfile()));
    }

    public void toggleSeans(ToggleEmployeeSeansRequest request) {
        Seans seans = this.seansesService.findOneById(request.getSeansId());

        Profile profile = this.profilesService.findCurrentProfile();

        IQueryBuilder<Employee> queryBuilder = new SearchEmployeeByProfileQueryBuilder(profile);

        Employee employee = this.employeesRepository.findOne(queryBuilder.getExample()).orElse(null);

        if (seans == null || employee == null) {
            throw new IllegalArgumentException("Invalid seans or employee ID");
        }

        if (employee.getSeanses().contains(seans)) {
            employee.getSeanses().remove(seans);
        } else {
            employee.getSeanses().add(seans);
        }

        this.employeesRepository.save(employee);
    }
}
