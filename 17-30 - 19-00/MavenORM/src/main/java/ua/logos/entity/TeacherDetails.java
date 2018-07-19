package ua.logos.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor

@Entity
@Table(name = "teacher_details")
@ToString(callSuper = true)
public class TeacherDetails extends BaseEntity {

	private String hobby;
	
	@Column(length = 120)
	private String experiance;
}
