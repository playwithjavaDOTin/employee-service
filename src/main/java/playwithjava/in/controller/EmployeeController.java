package playwithjava.in.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import playwithjava.in.bean.request.EmployeeRequest;
import playwithjava.in.bean.response.EmployeeResponse;
import playwithjava.in.constant.EmployeeServiceConstants;
import playwithjava.in.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping(EmployeeServiceConstants.EMPLOYEE_CONTROLLER_ENDPOINT)
@Slf4j
public class EmployeeController {

    @Autowired
    EmployeeService EmployeeService;


    @PostMapping(EmployeeServiceConstants.EMPLOYEE_ADD_EMPLOYEE_ENDPOINT)
    public ResponseEntity<EmployeeResponse> addEmployee(@RequestBody EmployeeRequest request){
        log.info("## Employee Controller :: add Employee");
        EmployeeResponse EmployeeResponse=EmployeeService.addEmployee(request);

        return new ResponseEntity(EmployeeResponse,HttpStatus.OK);
    }

    @GetMapping(EmployeeServiceConstants.EMPLOYEE_GET_EMPLOYEE_ENDPOINT+"/{sid}")
    public ResponseEntity<EmployeeResponse> getEmployeeById(@PathVariable Long sid){
        log.info("## Employee Controller :: add Employee");
        EmployeeResponse EmployeeResponse=EmployeeService.getEmployee(sid);

        return new ResponseEntity(EmployeeResponse,HttpStatus.OK);
    }

    @GetMapping(EmployeeServiceConstants.EMPLOYEE_GET_ALL_EMPLOYEE_ENDPOINT)
    public ResponseEntity<List<EmployeeResponse>> getAllEmployee(){
        log.info("## Employee Controller :: add Employee");
        List<EmployeeResponse> EmployeeResponse=EmployeeService.getAllEmployee();

        return new ResponseEntity(EmployeeResponse,HttpStatus.OK);
    }

}
