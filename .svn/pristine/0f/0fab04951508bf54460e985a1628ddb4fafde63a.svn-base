package controllers;

import model.Parameter;
import view.ParameterView;
import view.UpdateParameterView;

public class ParameterController {

	private Parameter parameter;
	private ParameterView parameterView;
	private UpdateParameterView updateParameterView;

	public ParameterController(Parameter parameter, ParameterView parameterView) {
		setParameter(parameter);
		setParameterView(parameterView);
		updateParameterView=null;
	}
	
	public ParameterController(Parameter parameter, UpdateParameterView updateParameterView) {
		setParameter(parameter);
		parameterView=null;
		setUpdateParameterView(updateParameterView);
	}

	public UpdateParameterView getUpdateParameterView() {
		return updateParameterView;
	}

	public void setUpdateParameterView(UpdateParameterView updateParameterView) {
		this.updateParameterView = updateParameterView;
	}

	public String updateParameter(String nazivParametra, String vrednostParametra) {
		if (nazivParametra == null) {
			return "Unesite naziv parametra";
		}
		nazivParametra = nazivParametra.trim();
		if (nazivParametra.isEmpty()) {
			return "Unesite naziv parametra";
		}

		if (vrednostParametra == null) {
			return "Unesite vrednost parametra";
		}
		vrednostParametra = vrednostParametra.trim();
		if (vrednostParametra.isEmpty()) {
			return "Unesite vrednost parametra";
		}

		parameter.setNazivParametra(nazivParametra);
		parameter.setVrednostParametra(vrednostParametra);

		return "Uspesno dodato";
	}

	public Parameter getParameter() {
		return parameter;
	}

	private void setParameter(Parameter parameter) {
		if (parameter == null) {
			throw new NullPointerException();
		}
		this.parameter = parameter;
	}

	public ParameterView getParameterView() {
		return parameterView;
	}

	private void setParameterView(ParameterView parameterView) {
		if (parameterView == null) {
			throw new NullPointerException();
		}
		this.parameterView = parameterView;
	}
}
