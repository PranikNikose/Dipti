package AtoZ;

public class ShopForRent extends BuildingForRent {
	private char shopType;

	public ShopForRent(int buildingDimensions, char shopType) {
		super(buildingDimensions);
		this.shopType = shopType;
	}

	// To_Trainee
	public int identifyShopRent() {
		// Write Your Code Here
		int shopRent;
		if (shopType == 'A') {
			shopRent = 45000;
		} else if (shopType == 'B') {
			shopRent = 30000;

		} else if (shopType == 'C') {
			shopRent = 25000;
		} else {
			shopRent = -1;
		}
		return shopRent;
	}

	// To_Trainee
	public void calculateAdvanceAmount() {
		// Write Your Code Here
		int shopRent;
		super.calculateAdvanceAmount();
		float basicAmount = super.getAdvanceAmount();
		shopRent = identifyShopRent();
		if (basicAmount == -1.0f && shopRent == -1.0f) {
			setAdvanceAmount(-1.0f);
		} else {
			setAdvanceAmount(basicAmount + shopRent);
		}
	}

	@Override
	public String toString() {
		return "ShopForRent [shopType=" + shopType + ", getBuildingDimensions()=" + getBuildingDimensions() + "]";
	}

}
