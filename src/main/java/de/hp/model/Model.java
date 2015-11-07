package de.hp.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Model {

	private final Map<Beer, Integer> tabMap;

	public Model() {
		this.tabMap = new LinkedHashMap<>();
	}

	public void addBeerToTab(Beer beer) {
		int amount = 1;
		if (tabMap.containsKey(beer)) {
			amount = tabMap.get(beer) + 1;
		}
		tabMap.put(beer, amount);
	}

	public int getAmountDrunkOfBeer(Beer beer) {
		Integer amount = tabMap.get(beer);
		if (null == amount) {
			return 0;
		}
		return amount;
	}

	public Set<Beer> getBeerTypesDrunk() {
		return tabMap.keySet();
	}

}
