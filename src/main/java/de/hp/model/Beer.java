package de.hp.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public enum Beer {

	HEINEKEN("Heineken", "3.20"), STERNBURG("Sternburg Pils", "2.30"), WERNESGRUENER("Wernesgrüner Pils",
			"3.10"), GUINNESS("Guinness", "3.30");

	private static final Map<String, Beer> STRING_TO_BEER_MAP = new HashMap<>();

	public static Beer getBeerByName(String name) {
		return STRING_TO_BEER_MAP.get(name);
	}

	static {
		for (Beer beer : values()) {
			STRING_TO_BEER_MAP.put(beer.longName, beer);
			STRING_TO_BEER_MAP.put(beer.name, beer);
		}
	}

	private final BigDecimal price;
	private final String longName;
	private final String name;

	private Beer(String name, String price) {
		this.name = name;
		this.price = new BigDecimal(price);
		this.longName = name + " – " + price + "€";
	}

	public BigDecimal getPrice() {
		return price;
	}

	public String getLongName() {
		return longName;
	}

	public String getName() {
		return name;
	}

}
