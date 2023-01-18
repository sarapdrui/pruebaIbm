package org.example.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Provider {
    private Integer id;
    private String Name;
    private Date dischargeDate;
    private Integer clientId;
}
