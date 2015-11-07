package de.hp.view.tavernview;

import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.VerticalLayout;

import de.hp.model.Beer;

@SuppressWarnings("serial")
public class SimpleTavernView extends VerticalLayout implements Button.ClickListener {

	public interface SimpleTabViewListener {

		void askForBeer(String beer);

		void askToPay();

	}

	private final SimpleTabViewListener viewListener;

	private ComboBox beerSelect;

	private Label currentBeerDisplay;

	public SimpleTavernView() {
		this.viewListener = new SimpleTavernViewPresenter(this);
	}

	public void init() {
		this.removeAllComponents();
		this.setMargin(true);

		Label greetingLabel = new Label("Hello traveler, care for a drink?");

		beerSelect = new ComboBox("Chose one of our Beers:");
		addBeers(Beer.HEINEKEN, Beer.STERNBURG, Beer.WERNESGRUENER, Beer.GUINNESS);

		Button orderButton = new Button("order it!");
		orderButton.addClickListener(this);

		currentBeerDisplay = new Label("You haven't ordered anything yet...");

		Button paymentButton = new Button("I wanna pay…");
		paymentButton.addClickListener(new Button.ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				viewListener.askToPay();
			}
		});

		this.addComponents(greetingLabel, beerSelect, orderButton, currentBeerDisplay, paymentButton);
	}

	private void addBeers(Beer... beers) {
		for (Beer beer : beers) {
			beerSelect.addItem(beer.getName());
			beerSelect.setItemCaption(beer.getName(), beer.getLongName());
		}
	}

	@Override
	public void buttonClick(ClickEvent event) {
		Object chosenBeer = beerSelect.getValue();
		System.out.println(chosenBeer);
		if (chosenBeer != null) {
			viewListener.askForBeer(chosenBeer.toString());
		}
	}

	public void setCurrentBeerDisplayValue(String currentBeerDisplayValue) {
		currentBeerDisplay.setValue(currentBeerDisplayValue);
	}

	public void showTab(String tab) {
		init();
		Notification notification = new Notification("Your tab:", tab, Type.HUMANIZED_MESSAGE);
		notification.setDelayMsec(-1);
		notification.show(Page.getCurrent());
	}

}
