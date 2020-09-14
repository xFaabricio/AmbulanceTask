package br.com.project.listener;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

import br.com.project.models.User;

public class Listener implements PhaseListener{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Override
    public void beforePhase(PhaseEvent arg0) {
    }

    @SuppressWarnings("unused")
	@Override
    public void afterPhase(PhaseEvent arg0) {
    	FacesContext ctx = FacesContext.getCurrentInstance();
        if(!ctx.getViewRoot().getViewId().equals("/Login.xhtml")){
            Application app = ctx.getApplication();
            User user = app.evaluateExpressionGet(ctx, "#{usuario}", User.class);
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return null;
    }

}
