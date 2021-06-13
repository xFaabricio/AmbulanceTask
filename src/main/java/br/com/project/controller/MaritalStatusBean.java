package br.com.project.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import br.com.project.schedule.MaritalStatus;

@ManagedBean
public class MaritalStatusBean {
  public SelectItem[] getMaritalStatusValues() {
    SelectItem[] items = new SelectItem[MaritalStatus.values().length];
    int i = 0;
    for(MaritalStatus g: MaritalStatus.values()) {
      items[i++] = new SelectItem(g, g.getStatus());
    }
    return items;
  }
}
