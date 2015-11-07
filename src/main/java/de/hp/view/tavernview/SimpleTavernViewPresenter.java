package de.hp.view.tavernview;

import java.math.BigDecimal;
import java.util.Set;

import de.hp.model.Beer;
import de.hp.model.Model;
import de.hp.view.tavernview.SimpleTavernView.SimpleTabViewListener;

public class SimpleTavernViewPresenter implements SimpleTabViewListener {

	private final SimpleTavernView view;

	private final Model model;

	public SimpleTavernViewPresenter(SimpleTavernView view) {
		this.view = view;
		this.model = new Model();
	}

	@Override
	public void askForBeer(String beer) {
		// TODO call 'BeerTabService'

		// TODO add checks for null / invalid value + unit tests
		model.addBeerToTab(Beer.getBeerByName(beer));

		view.setCurrentBeerDisplayValue("The bartender brings you a fresh " + beer);
	}

	@Override
	public void askToPay() {
		Set<Beer> beerTypes = model.getBeerTypesDrunk();
		StringBuilder sb = new StringBuilder();
		BigDecimal sum = new BigDecimal(0);
		for (Beer beer : beerTypes) {
			BigDecimal amount = new BigDecimal(model.getAmountDrunkOfBeer(beer));
			BigDecimal price = beer.getPrice();
			BigDecimal product = price.multiply(amount);
			sum = sum.add(product);
			sb.append(amount).append("x ").append(beer).append("\t").append(product).append("€\n");
		}
		sb.append("---\ntotal:\t\t").append(sum).append("€");
		view.showTab(sb.toString());
	}

}
