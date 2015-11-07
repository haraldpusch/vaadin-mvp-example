package de.hp;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Widgetset;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

import de.hp.view.tavernview.SimpleTavernView;

/**
 *
 */
@SuppressWarnings("serial")
@Theme("mytheme")
@Widgetset("de.hp.MyAppWidgetset")
public class MainUI extends UI {

	/**
	 * With servlet 3.0 specification we don't need a web.xml deployment descriptor anymore and can just do this like this:
	 */
    @WebServlet(urlPatterns = "/*", name = "MainServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MainUI.class, productionMode = false)
    public static class MainServlet extends VaadinServlet {
    }

    @Override
    protected void init(VaadinRequest vaadinRequest) {
    	SimpleTavernView simpleTabView = new SimpleTavernView();
    	simpleTabView.init();
    	setContent(simpleTabView);
    }

}
