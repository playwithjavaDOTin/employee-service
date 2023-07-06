package playwithjava.in.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import playwithjava.in.bean.request.EmployeeRequest;
import playwithjava.in.bean.response.EmployeeResponse;
import playwithjava.in.entity.EmployeeEntity;
import playwithjava.in.mapper.EmployeeMapperService;
import playwithjava.in.repository.EmployeeRepository;
import playwithjava.in.service.EmployeeService;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeRepository EmployeeRepository;

    @Autowired
    EmployeeMapperService mapperService;

    @Override
    public EmployeeResponse addEmployee(EmployeeRequest request) {
        EmployeeEntity employeeEntity=mapperService.mapEmployeeReqToEntity(request);
        EmployeeEntity entity= EmployeeRepository.save(employeeEntity);
        EmployeeResponse employeeResponse=mapperService.mapEmployeeEntityToResponse(entity);
        return employeeResponse;
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest request) {
        return null;
    }

    @Override
    public EmployeeResponse getEmployee(Long sid) {
        Optional<EmployeeEntity> employeeEntity=EmployeeRepository.findById(sid);
        return mapperService.mapEmployeeEntityToResponse(employeeEntity.get());
    }

    @Override
    public List<EmployeeResponse> getAllEmployee() {

        List<EmployeeEntity> employeeEntities= EmployeeRepository.findAll();

        Function<EmployeeEntity,EmployeeResponse> convert=(x)->mapperService.mapEmployeeEntityToResponse(x);
        List<EmployeeResponse> responses=employeeEntities.stream()
                .map(convert)
                .collect(Collectors.toList());
        return responses;
    }

    @Override
    public void deleteEmployee(Long sid) {
        EmployeeRepository.deleteById(sid);
    }
}
