package com.LSG.UMS.Requests;

import com.LSG.UMS.Models.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequestBody {
    private Long id;
    private String name;
    private String email;
    private Boolean isAdmin;
}
