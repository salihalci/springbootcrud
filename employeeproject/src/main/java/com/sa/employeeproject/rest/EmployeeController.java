package com.sa.employeeproject.rest;

import com.sa.employeeproject.entity.Employee;
import com.sa.employeeproject.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import tools.jackson.databind.json.JsonMapper;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private EmployeeService employeeService;
    private JsonMapper jsonMapper;

    public EmployeeController(EmployeeService employeeService, JsonMapper thejsonMapper) {
        this.employeeService = employeeService;
        this.jsonMapper = thejsonMapper;
    }

    @GetMapping("/employees")
    public List<Employee> retrieveEmployees() {

        return employeeService.findAll();
    }

    @GetMapping("/employees/{userId}")
    public Employee retrieveEmpployee(@PathVariable int userId) {

        return employeeService.findById(userId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee theEmployee) {

        theEmployee.setId(0); // 0 ise insert

        Employee dbEmployee = employeeService.save(theEmployee);

        return dbEmployee;

    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee theEmployee) {

        if (employeeService.findById(theEmployee.getId()) == null) {

            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee not found : "+theEmployee.getId());
        } else {
            Employee dbEmployee = employeeService.save(theEmployee);

            return dbEmployee;
        }
    }

    @PatchMapping("/employees/{employeeId}")
    public Employee patchEmployee(@PathVariable int employeeId,
                                  @RequestBody Map<String,Object> pathchPayload){

        Employee tempEmployee = employeeService.findById(employeeId);

        if (tempEmployee == null)
            throw new RuntimeException("Employee not found : "+employeeId);

        if (pathchPayload.containsKey("id"))
            throw new RuntimeException("EmployeeID not allowed in request body! "+employeeId);

        Employee pathcedEmployee = jsonMapper.updateValue(tempEmployee,pathchPayload);

        Employee dbEmployee = employeeService.save(pathcedEmployee);

        return dbEmployee;
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId){
        Employee themployee = employeeService.findById(employeeId);

        if(themployee==null)
            throw new RuntimeException("Employee not found");


        employeeService.deleteById(employeeId);

        System.out.println(themployee.toString());
        return "Deleted employee id "+employeeId;
    }

}
