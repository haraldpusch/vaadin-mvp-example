package de.hp.view.tavernview;

import de.hp.view.tavernview.SimpleTavernView.SimpleTabViewListener;

public class SimpleTavernViewPresenter implements SimpleTabViewListener {

	private final SimpleTavernView view;

	public SimpleTavernViewPresenter(SimpleTavernView view) {
		this.view = view;
	}

	@Override
	public void askForBeer(String beer) {
		// TODO call 'BeerTabService'
		view.setCurrentBeerDisplayValue("The bartender brings you a fresh " + beer);
	}

}
