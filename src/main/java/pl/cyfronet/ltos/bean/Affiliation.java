package pl.cyfronet.ltos.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Affiliation  {

    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;   
    private String country;
    private String institution;
    private String department;
    private String webPage;
    private String supervisorName;
    private String supervisorEmail;
    private String status;
    private Date lastUpdateDate;
    private String userEmail;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    private User owner;

}	