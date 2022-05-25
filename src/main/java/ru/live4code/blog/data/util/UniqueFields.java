package ru.live4code.blog.data.util;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Data
@MappedSuperclass
public class UniqueFields {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @CreatedDate
    @Column(name = "created_at")
    private Date created_at;

    @LastModifiedDate
    @Column(name = "updated_at")
    private Date updated_at;
}
