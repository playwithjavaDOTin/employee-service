package playwithjava.in.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import playwithjava.in.bean.request.EmployeeRequest;
import playwithjava.in.bean.response.EmployeeResponse;
import playwithjava.in.entity.EmployeeEntity;


@Service
public class EmployeeMapperServiceImpl implements EmployeeMapperService{

    @Autowired
    ModelMapper mapper;

    @Override
    public EmployeeEntity mapEmployeeReqToEntity(EmployeeRequest request) {
        EmployeeEntity employeeEntity= EmployeeEntity.builder().build();
        mapper.map(request,employeeEntity);
        return employeeEntity;
    }

    @Override
    public EmployeeResponse mapEmployeeEntityToResponse(EmployeeEntity entity) {
        EmployeeResponse response=EmployeeResponse.builder().build();
        mapper.map(entity,response);
        return response;
    }
}
