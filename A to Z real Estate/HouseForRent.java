package AtoZ;

import java.util.Arrays;

public class HouseForRent extends BuildingForRent {
	private int noOfBedrooms;
	private String[] facilities;
	private static String[][] facilitiesDetailsArr = { { "Security", "Parking", "Amusement-Park" },
			{ "2000", "3400", "2900" } };

	public HouseForRent(int buildingDimensions, int noOfBedrooms, String[] facitlities) {
		super(buildingDimensions);
		this.noOfBedrooms = noOfBedrooms;
		this.facilities = facitlities;
	}

	public int getNoOfBedrooms() {
		return noOfBedrooms;
	}

	public String[] getFacitlities() {
		return facilities;
	}

	// To_Trainee
	public boolean validateNoOfBedrooms() {
		// Write Your Code Here
		boolean result = false;
		if (this.noOfBedrooms > 0 && this.noOfBedrooms < 6) {
			result = true;
		}
		return result;
	}

	// To_Trainee
	public void calculateAdvanceAmount() {

		// Write Your Code Here
		super.calculateAdvanceAmount();

		float basicAmount = super.getAdvanceAmount();

		validateNoOfBedrooms();

		if (basicAmount == -1.0f || validateNoOfBedrooms() == false || facilities.equals("null")) {
			setAdvanceAmount(-1.0f);
		} else {
			float totalFacilityCharge = 0;
			for (String facility : facilities) {
				if (facility.equalsIgnoreCase(facilitiesDetailsArr[0][0])) {
					totalFacilityCharge += Float.parseFloat(facilitiesDetailsArr[1][0]);
				} else if (facility.equalsIgnoreCase(facilitiesDetailsArr[0][1])) {
					totalFacilityCharge += Float.parseFloat(facilitiesDetailsArr[1][1]);
				} else if (facility.equalsIgnoreCase(facilitiesDetailsArr[0][2])) {
					totalFacilityCharge += Float.parseFloat(facilitiesDetailsArr[1][2]);
				}
			}
			if (totalFacilityCharge != 0.0f) {
				float BedroomCharges = noOfBedrooms * 20000;
				float advancedAmount = totalFacilityCharge + basicAmount + BedroomCharges;
				setAdvanceAmount(advancedAmount);
			} else {
				setAdvanceAmount(-1.0f);
			}
		}
	}

	@Override
	public String toString() {
		return "HouseForRent [noOfBedrooms=" + noOfBedrooms + ", facitlities=" + Arrays.toString(facilities)
				+ ", getBuildingDimensions()=" + getBuildingDimensions() + "]";
	}

}
