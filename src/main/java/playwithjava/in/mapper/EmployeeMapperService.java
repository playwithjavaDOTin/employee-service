package playwithjava.in.mapper;

import playwithjava.in.bean.request.EmployeeRequest;
import playwithjava.in.bean.response.EmployeeResponse;
import playwithjava.in.entity.EmployeeEntity;

public interface EmployeeMapperService {

    EmployeeEntity mapEmployeeReqToEntity(EmployeeRequest request);
    EmployeeResponse mapEmployeeEntityToResponse(EmployeeEntity request);
}
