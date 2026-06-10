package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.PersonDTO;
import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private DepartmentRepository departmentRepository;

    public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {

        Person peopleEntity = new Person();
        peopleEntity.setName(dto.getName());
        peopleEntity.setSalary(dto.getSalary());

        Department deptEntity = departmentRepository.getReferenceById(
                dto.getDepartment().getId()
        );

        peopleEntity.setDepartment(deptEntity);

        peopleEntity = personRepository.save(peopleEntity);

        return new PersonDepartmentDTO(peopleEntity);
    }

    public PersonDTO insert(PersonDTO dto) {

        Person peopleEntity = new Person();
        peopleEntity.setName(dto.getName());
        peopleEntity.setSalary(dto.getSalary());

        /* Department deptEntity = departmentRepository.getReferenceById(
                dto.getDepartmentId()
        );*/

        Department deptEntity = new Department();
        deptEntity.setId(dto.getDepartmentId());

        peopleEntity.setDepartment(deptEntity);

        peopleEntity = personRepository.save(peopleEntity);

        return new PersonDTO(peopleEntity);
    }
}
