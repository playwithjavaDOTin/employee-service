package playwithjava.in.service;

import org.springframework.stereotype.Service;
import playwithjava.in.bean.request.EmployeeRequest;
import playwithjava.in.bean.response.EmployeeResponse;

import java.util.List;

@Service
public interface EmployeeService {

    public EmployeeResponse addEmployee(EmployeeRequest request);
    public EmployeeResponse updateEmployee(EmployeeRequest request);
    public EmployeeResponse getEmployee(Long sid);
    public List<EmployeeResponse> getAllEmployee();
    public void deleteEmployee(Long sid);
}
