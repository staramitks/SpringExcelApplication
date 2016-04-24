/**
 * @Author Amit Kumar Singh
 * Mumbai
 */
package com.aks.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shilpisingh
 *
 */
public class EmployeeDashboardDTO {
	
	
	private String stepName;
	private String stepNo;
	private String cycleName;
	private int referenceDuration;
	private List<Integer> deviationList= new ArrayList<Integer>();

	
	/**
	 * @return the stepName
	 */
	
	public String getStepName() {
		return stepName;
	}
	/**
	 * @param stepName the stepName to set
	 */
	public void setStepName(String stepName) {
		this.stepName = stepName;
	}
	/**
	 * @return the stepNo
	 */
	public String getStepNo() {
		return stepNo;
	}
	/**
	 * @param stepNo the stepNo to set
	 */
	public void setStepNo(String stepNo) {
		this.stepNo = stepNo;
	}
	/**
	 * @return the cycleName
	 */
	public String getCycleName() {
		return cycleName;
	}
	/**
	 * @param cycleName the cycleName to set
	 */
	public void setCycleName(String cycleName) {
		this.cycleName = cycleName;
	}
	/**
	 * @return the deviationList
	 */
	public List<Integer> getDeviationList() {
		return deviationList;
	}
	/**
	 * @param deviationList the deviationList to set
	 */
	public void setDeviationList(List<Integer> deviationList) {
		this.deviationList = deviationList;
	}
	public int getReferenceDuration() {
		return referenceDuration;
	}
	public void setReferenceDuration(int referenceDuration) {
		this.referenceDuration = referenceDuration;
	}
	

}
