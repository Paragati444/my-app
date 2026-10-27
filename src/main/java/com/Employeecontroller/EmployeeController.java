package com.Employeecontroller;

import com.Employee.dto.EmployeeDTO;
import com.EmployeeService.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    // CREATE
    @PostMapping("/employees")
    public ResponseEntity<String> createEmployee(@RequestBody EmployeeDTO employeeDTO) {
        String result = employeeService.createEmployee(employeeDTO);
        return ResponseEntity.ok(result);
    }

    // GET ALL
    @GetMapping("/employees")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.readEmployees());
    }

    // GET BY ID
    @GetMapping("/employees/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        EmployeeDTO dto = employeeService.readEmployee(id);
        if (dto != null) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();
    }

    // UPDATE
    @PutMapping("/employees/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id,
                                                   @RequestBody EmployeeDTO employeeDTO) {
        System.out.println("🔥 PUT HIT ID = " + id);
        boolean updated = employeeService.updateEmployee(id, employeeDTO);
        System.out.println("🔥 UPDATED STATUS = " + updated);

        if (updated) {
            return ResponseEntity.ok("Updated Successfully");
        }
        return ResponseEntity.status(404).body("ID NOT FOUND");
    }

    // DELETE
    @DeleteMapping("/employees/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        boolean deleted = employeeService.deleteEmployee(id);
        if (deleted) {
            return ResponseEntity.ok("Deleted Successfully");
        }
        return ResponseEntity.notFound().build();
    }
}