package com.akulinski.piformer.core.domain;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import java.io.Serializable;
import java.util.Date;

@Data
@Slf4j
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Auditable implements Serializable {

    @Id
    private Long id;

    @CreatedDate
    private Date createdDate;

    @LastModifiedDate
    private Date lastModifiedDate;


}
