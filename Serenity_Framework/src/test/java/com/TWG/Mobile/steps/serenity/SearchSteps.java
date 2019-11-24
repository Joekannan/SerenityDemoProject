package com.TWG.Mobile.steps.serenity;

import com.TWG.Mobile.pages.SearchPage;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

public class SearchSteps extends ScenarioSteps{
	
	SearchPage search;
	
	@Step
	public void SearchClick() throws InterruptedException {
		search.clickSearch();
	}
	
	@Step
	public void SearchString(String text) {
		search.enterSearchText(text);
	}

	@Step
	public void SearchResultClick() {
		search.resultClick();
	}
}
