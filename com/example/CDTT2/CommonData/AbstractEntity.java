package com.example.CDTT2.CommonData;

import java.time.LocalDateTime;

import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import com.example.CDTT2.Ultils.DateUltils;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonEncoding;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Long id;
	
	
	@CreatedBy
	private String createdBy;
	
	@LastModifiedBy
	private String updatedBy;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = DateUltils.Date_Time_Format)
	@DateTimeFormat(pattern = DateUltils.Date_Time_Format)
	@CreatedDate
	protected LocalDateTime createdAt;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING,pattern = DateUltils.Date_Time_Format)
	@DateTimeFormat(pattern = DateUltils.Date_Time_Format)
	@LastModifiedDate
	protected LocalDateTime updatedAt;
}
