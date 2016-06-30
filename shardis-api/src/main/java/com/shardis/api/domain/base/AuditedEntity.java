package com.shardis.api.domain.base;

import com.shardis.api.domain.user.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.envers.Audited;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.LocalDateTime;

/**
 * Created by Tomasz Kucharzyk
 */
@Audited
@Data
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class AuditedEntity extends BaseEntity {

    @CreatedDate
    protected LocalDateTime createdDate;

    @CreatedBy
    @ManyToOne
    protected User createdBy;

    @LastModifiedDate
    protected LocalDateTime updatedDate;

    @LastModifiedBy
    @ManyToOne
    protected User updatedBy;

    @Version
    protected Long version;

}
