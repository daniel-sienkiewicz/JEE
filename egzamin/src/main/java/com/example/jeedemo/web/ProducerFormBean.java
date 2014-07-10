package com.example.jeedemo.web;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jeedemo.domain.Producer;
import com.example.jeedemo.service.ProducerManager;

@SessionScoped
@Named("producerF")
public class ProducerFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Producer producer = new Producer();
	private ListDataModel<Producer> producers = new ListDataModel<Producer>();
	private ListDataModel<Producer> sProducers = new ListDataModel<Producer>();
	private Producer producerToUpdate = new Producer();

	private String town;

	@Inject
	private ProducerManager pm;

	public Producer getProducerToUpdate() {
		return producerToUpdate;
	}

	public void setProducerToUpdate(Producer producerToUpdate) {
		this.producerToUpdate = producerToUpdate;
	}

	public Producer getProducer() {
		return producer;
	}

	public String getTown() {
		return town;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public ListDataModel<Producer> getAllProducer() {
		producers.setWrappedData(pm.getAllProducers());
		return producers;
	}

	public ListDataModel<Producer> getSProducer() {
		sProducers.setWrappedData(pm.getSProducers(town));
		return sProducers;
	}

	// Actions
	public String addProducer() {
		pm.addProducer(producer);
		return "producerList";
	}

	public String deleteProducer() {
		int wynik;
		Producer producerToDelete = producers.getRowData();
		wynik = pm.deleteProducer(producerToDelete);

		if (wynik == 1)
			return null;

		else
			return "delError";
	}

	public String getSomeProducer() {
		sProducers.setWrappedData(pm.getSProducers(town));
		return null;
	}

	public String updateProducer(String name) {
		producerToUpdate = pm.getSProducersName(name).get(0);
		return "updateProducer";
	}

	public String updateSProducer() {
		pm.updateProducer(producerToUpdate);
		return "producerList";
	}

	// Validators
	public void producerName(FacesContext context, UIComponent component, Object value) {

		String producerName = (String) value;

		for (Producer producer : pm.getAllProducers()) {
			if (producer.getName().equalsIgnoreCase(producerName)) {
				FacesMessage message = new FacesMessage("Producer exists in database");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
}