package com.warehouse.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.Getter;

@MappedSuperclass
@Getter
@EntityListeners(AuditingEntityListener.class)
@Table
public abstract class BaseModel {

	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(length = 36)
	private String uuid;

	@CreatedDate
	@Column(name = "create_date", updatable = false, nullable = false)
	private LocalDateTime createDate;

	@CreatedBy
	@Column(name = "create_user", updatable = false, nullable = false)
	private String createUser;

	@LastModifiedBy
	private String modifiedBy;

	@LastModifiedDate
	private LocalDateTime modifiedDate;

	private LocalDateTime removedDate;

}
