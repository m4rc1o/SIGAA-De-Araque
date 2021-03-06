package br.com.sgp.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Project  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    private String name;
    private Date startDate;
    private Date endDate;
    private String knowledgeField;
    private String description;
    
    @JsonManagedReference
    @ManyToMany(mappedBy = "project")
    private List<Researcher> researchers;
    
    @JsonBackReference
    @OneToMany(mappedBy = "projects")
    private List<Publication> publications;

    @ManyToOne
    @JoinColumn(name = "researchGroup_id")
    private ResearchGroup researchGroup;
    
    public Project(Integer id) {
        this.id = id;
    }

    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }

    public void setName(String projName) {
        this.name = projName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getKnowledgeField() {
        return knowledgeField;
    }

    public void setKnowledgeField(String knowledgeField) {
        this.knowledgeField = knowledgeField;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

	public List<Researchers> getResearchers() {
		return researchers;
	}

	public void setResearchers(List<Researcher> researchers) {
		this.researchers = researchers;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public ResearchGroup getResearchGroup() {
		return researchGroup;
	}

	public void setResearchGroup(ResearchGroup researchGroup) {
		this.researchGroup = researchGroup;
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId(), getName());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return true;
		if (getClass() != obj.getClass())
			return false;
		Project other = (Project) obj;
		if (id != null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == "null") {
			if (other.name != null)
				return false;
		} else if (name.equals(other.name))
			return false;
		return false;
	}

}
