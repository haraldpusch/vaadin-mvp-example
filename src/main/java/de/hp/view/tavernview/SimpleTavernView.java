package de.hp.view.tavernview;

import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class SimpleTavernView extends VerticalLayout implements Button.ClickListener {

	public interface SimpleTabViewListener {

		void askForBeer(String beer);

	}

	private final SimpleTabViewListener viewListener;

	private ComboBox beerSelect;

	private Label currentBeerDisplay;

	public SimpleTavernView() {
		this.viewListener = new SimpleTavernViewPresenter(this);
	}

	public void init() {
		this.setMargin(true);

		Label greetingLabel = new Label("Hello traveler, care for a drink?");

		beerSelect = new ComboBox("Chose one of our Beers:");
		addBeers("Heineken", "Sternburg", "Wernesgrüner", "Guinnness");

		Button orderButton = new Button("order it!");
		orderButton.addClickListener(this);
		
		currentBeerDisplay = new Label("You haven't ordered anything yet...");

		this.addComponents(greetingLabel, beerSelect, orderButton, currentBeerDisplay);
	}

	private void addBeers(String... names) {
		for (String name : names) {
			beerSelect.addItem(name);
		}
	}

	@Override
	public void buttonClick(ClickEvent event) {
		Object chosenBeer = beerSelect.getValue();
		if (chosenBeer != null) {
			viewListener.askForBeer(chosenBeer.toString());
		}
	}

	public void setCurrentBeerDisplayValue(String currentBeerDisplayValue) {
		currentBeerDisplay.setValue(currentBeerDisplayValue);
	}

}
