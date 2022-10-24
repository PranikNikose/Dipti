package AtoZ;

public class BuildingForRent {

	private int buildingDimensions;
	private float advanceAmount;

	public BuildingForRent(int buildingDimensions) {
		this.buildingDimensions = buildingDimensions;
	}

	public int getBuildingDimensions() {
		return buildingDimensions;
	}

	public float getAdvanceAmount() {
		return advanceAmount;
	}

	public void setAdvanceAmount(float advanceAmount) {
		this.advanceAmount = advanceAmount;
	}

	public void calculateAdvanceAmount() {
		float advancedAmount = -1.0f;
		if (this.buildingDimensions > 0) {
			advancedAmount = this.buildingDimensions * 10;
		}
		this.advanceAmount = advancedAmount;
	}

	@Override
	public String toString() {
		return "BuildingForRent [buildingDimensions=" + buildingDimensions + ", advanceAmount=" + advanceAmount + "]";
	}

}
