package playwithjava.in.bean.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder(toBuilder = true)
public class EmployeeRequest {
    private String name;
    private String email;
    private Long salary;

}
