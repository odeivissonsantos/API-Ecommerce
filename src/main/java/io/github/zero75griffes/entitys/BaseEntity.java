package io.github.zero75griffes.entitys;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@RequiredArgsConstructor
public class BaseEntity {

    private String guid;
}
