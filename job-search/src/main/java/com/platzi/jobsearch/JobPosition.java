package com.platzi.jobsearch;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

public class JobPosition {
	
	private String id;
	
	private String type;
	
	private String url;
	
	@SerializedName("created_at")
	private String createdAt;
	
	private String company;
	
	@SerializedName("company_url")
	private String companyUrl;
	
	private String title;
	
	private String location;
	
	private String description;
	
	@SerializedName("company_logo")
	private String companyLogo;

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getCompanyUrl() {
		return companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCompanyLogo() {
		return companyLogo;
	}

	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(company, companyLogo, companyUrl, createdAt, description, id, location, title, type, url);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JobPosition other = (JobPosition) obj;
		return Objects.equals(company, other.company) && Objects.equals(companyLogo, other.companyLogo)
				&& Objects.equals(companyUrl, other.companyUrl) && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(description, other.description) && Objects.equals(id, other.id)
				&& Objects.equals(location, other.location) && Objects.equals(title, other.title)
				&& Objects.equals(type, other.type) && Objects.equals(url, other.url);
	}

	@Override
	public String toString() {
		return "JobPosition [id=" + id + ", type=" + type + ", url=" + url + ", createdAt=" + createdAt + ", company="
				+ company + ", companyUrl=" + companyUrl + ", title=" + title + ", location=" + location
				+ ", description=" + description + ", companyLogo=" + companyLogo + "]";
	}
	
	
	
}
