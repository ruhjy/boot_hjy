package com.example.demo.domain.test;

public class CategoryForm {

	private String categoryName;
	private String description;

	public CategoryForm() {
	}

	public CategoryForm(String categoryName, String description) {
		this.categoryName = categoryName;
		this.description = description;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
